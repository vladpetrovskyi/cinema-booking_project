package com.cinema.model.mapper.impl;

import com.cinema.model.ShoppingCart;
import com.cinema.model.Ticket;
import com.cinema.model.dto.request.ShoppingCartRequestDto;
import com.cinema.model.dto.request.TicketRequestDto;
import com.cinema.model.dto.response.ShoppingCartResponseDto;
import com.cinema.model.dto.response.TicketResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoppingCartMapperImpl
        implements ItemMapper<ShoppingCart, ShoppingCartRequestDto, ShoppingCartResponseDto> {

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ItemMapper<Ticket, TicketRequestDto, TicketResponseDto> itemMapper;

    @Override
    public ShoppingCart toEntity(ShoppingCartRequestDto dto) {
        return shoppingCartService.getByUser(userService.getById(dto.getUserId()));
    }

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart entity) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setUserId(entity.getUser().getId());
        dto.setTickets(entity.getTickets()
                .stream()
                .map(itemMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
