package com.cinema.model.mapper.impl;

import com.cinema.model.Order;
import com.cinema.model.Ticket;
import com.cinema.model.dto.request.OrderRequestDto;
import com.cinema.model.dto.request.TicketRequestDto;
import com.cinema.model.dto.response.OrderResponseDto;
import com.cinema.model.dto.response.TicketResponseDto;
import com.cinema.model.mapper.ItemMapper;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapperImpl implements ItemMapper<Order, OrderRequestDto, OrderResponseDto> {

    private final ItemMapper<Ticket, TicketRequestDto, TicketResponseDto> itemMapper;

    @Override
    public Order toEntity(OrderRequestDto dto) {
        return new Order();
    }

    @Override
    public OrderResponseDto toDto(Order entity) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderTime(entity.getOrderTime());
        dto.setUserId(entity.getUser().getId());
        dto.setTickets(entity.getTickets()
                .stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
