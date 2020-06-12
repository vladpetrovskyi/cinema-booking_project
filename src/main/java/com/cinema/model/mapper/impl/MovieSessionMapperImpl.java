package com.cinema.model.mapper.impl;

import com.cinema.model.MovieSession;
import com.cinema.model.dto.request.MovieSessionRequestDto;
import com.cinema.model.dto.response.MovieSessionResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.CinemaHallService;
import com.cinema.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl
        implements ItemMapper<MovieSession, MovieSessionRequestDto, MovieSessionResponseDto> {

    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSession toEntity(MovieSessionRequestDto dto) {
        MovieSession entity = new MovieSession();
        entity.setMovie(movieService.getById(dto.getMovieId()));
        entity.setCinemaHall(cinemaHallService.getById(dto.getCinemaHallId()));
        entity.setShowTime(dto.getShowTime());
        return entity;
    }

    @Override
    public MovieSessionResponseDto toDto(MovieSession entity) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setMovieSessionId(entity.getId());
        dto.setShowTime(entity.getShowTime());
        dto.setCinemaHallId(entity.getCinemaHall().getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setMovieTitle(entity.getMovie().getTitle());
        return dto;
    }
}
