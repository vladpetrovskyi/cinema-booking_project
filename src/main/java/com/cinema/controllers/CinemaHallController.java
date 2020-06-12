package com.cinema.controllers;

import com.cinema.model.CinemaHall;
import com.cinema.model.dto.request.CinemaHallRequestDto;
import com.cinema.model.dto.response.CinemaHallResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cinema-halls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;

    private final ItemMapper<CinemaHall, CinemaHallRequestDto, CinemaHallResponseDto> itemMapper;

    public CinemaHallController(
            CinemaHallService cinemaHallService,
            ItemMapper<CinemaHall, CinemaHallRequestDto, CinemaHallResponseDto> itemMapper) {
        this.cinemaHallService = cinemaHallService;
        this.itemMapper = itemMapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto requestDto) {
        cinemaHallService.add(itemMapper.toEntity(requestDto));
    }
}
