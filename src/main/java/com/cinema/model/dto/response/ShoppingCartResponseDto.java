package com.cinema.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private List<TicketResponseDto> tickets;
    private Long userId;
}
