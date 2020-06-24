package com.cinema.controllers;

import com.cinema.model.Movie;
import com.cinema.model.dto.request.MovieRequestDto;
import com.cinema.model.dto.response.MovieResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ItemMapper<Movie, MovieRequestDto, MovieResponseDto> itemMapper;

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addMovie(@RequestBody @Valid MovieRequestDto requestDto) {
        movieService.add(itemMapper.toEntity(requestDto));
    }
}
