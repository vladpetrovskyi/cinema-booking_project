package com.cinema.model.mapper.impl;

import com.cinema.model.Ticket;
import com.cinema.model.dto.request.TicketRequestDto;
import com.cinema.model.dto.response.TicketResponseDto;
import com.cinema.model.mapper.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketMapperImpl implements ItemMapper<Ticket, TicketRequestDto, TicketResponseDto> {
    @Override
    public Ticket toEntity(TicketRequestDto dto) {
        return new Ticket();
    }

    @Override
    public TicketResponseDto toDto(Ticket entity) {
        TicketResponseDto dto = new TicketResponseDto();
        dto.setTicketId(entity.getId());
        dto.setCinemaHallId(entity.getMovieSession().getCinemaHall().getId());
        dto.setMovieSessionId(entity.getMovieSession().getId());
        dto.setMovieTitle(entity.getMovieSession().getMovie().getTitle());
        dto.setShowTime(entity.getMovieSession().getShowTime());
        return dto;
    }
}
