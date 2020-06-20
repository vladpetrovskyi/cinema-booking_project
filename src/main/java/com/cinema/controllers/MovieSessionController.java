package com.cinema.controllers;

import com.cinema.model.MovieSession;
import com.cinema.model.dto.request.MovieSessionRequestDto;
import com.cinema.model.dto.response.MovieSessionResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movie-sessions")
@AllArgsConstructor
public class MovieSessionController {

    private final MovieSessionService movieSessionService;
    private final ItemMapper<MovieSession,
            MovieSessionRequestDto, MovieSessionResponseDto> itemMapper;

    @PostMapping
    public void addMovieSession(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        movieSessionService.add(itemMapper.toEntity(requestDto));
    }

    @GetMapping(value = "/available")
    public List<MovieSessionResponseDto> getAllAvailable(
            @RequestParam(required = false)
            @Min(value = 1, message = "Movie ID cannot be less than 1!") Long movieId,
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE, pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(itemMapper::toDto).collect(Collectors.toList());
    }
}
