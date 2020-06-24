package com.cinema.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CinemaHallResponseDto {
    private Long cinemaHallId;
    private Long capacity;
    private String details;
}
