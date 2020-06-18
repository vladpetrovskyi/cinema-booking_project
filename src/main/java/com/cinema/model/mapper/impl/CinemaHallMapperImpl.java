package com.cinema.model.mapper.impl;

import com.cinema.model.CinemaHall;
import com.cinema.model.dto.request.CinemaHallRequestDto;
import com.cinema.model.dto.response.CinemaHallResponseDto;
import com.cinema.model.mapper.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl
        implements ItemMapper<CinemaHall, CinemaHallRequestDto, CinemaHallResponseDto> {
    @Override
    public CinemaHall toEntity(CinemaHallRequestDto dto) {
        CinemaHall entity = new CinemaHall();
        entity.setCapacity(dto.getCapacity());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public CinemaHallResponseDto toDto(CinemaHall entity) {
        CinemaHallResponseDto dto = new CinemaHallResponseDto();
        dto.setCinemaHallId(entity.getId());
        dto.setDetails(entity.getDescription());
        dto.setCapacity(entity.getCapacity());
        return dto;
    }
}
