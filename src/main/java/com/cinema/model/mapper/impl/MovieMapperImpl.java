package com.cinema.model.mapper.impl;

import com.cinema.model.Movie;
import com.cinema.model.dto.request.MovieRequestDto;
import com.cinema.model.dto.response.MovieResponseDto;
import com.cinema.model.mapper.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements ItemMapper<Movie, MovieRequestDto, MovieResponseDto> {
    @Override
    public Movie toEntity(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }

    @Override
    public MovieResponseDto toDto(Movie entity) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setMovieId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
