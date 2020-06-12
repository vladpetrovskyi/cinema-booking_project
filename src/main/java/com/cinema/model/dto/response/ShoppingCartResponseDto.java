package com.cinema.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<TicketResponseDto> tickets;
    private Long userId;

    public List<TicketResponseDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponseDto> tickets) {
        this.tickets = tickets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
