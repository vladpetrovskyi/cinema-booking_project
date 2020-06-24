package com.cinema.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDto {
    private Long ticketId;
    private Long movieSessionId;
    private String movieTitle;
    private Long cinemaHallId;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    private LocalDateTime showTime;
}
