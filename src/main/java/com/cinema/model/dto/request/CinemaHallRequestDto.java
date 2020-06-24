package com.cinema.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CinemaHallRequestDto {
    @NotNull(message = "'capacity' field can't be empty!")
    private Long capacity;

    private String description;
}
