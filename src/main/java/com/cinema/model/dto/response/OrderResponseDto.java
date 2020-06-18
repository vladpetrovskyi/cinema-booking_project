package com.cinema.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long userId;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime orderTime;
    private List<TicketResponseDto> tickets;
}
