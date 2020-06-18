package com.cinema.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDto {
    private Long movieId;
    private String title;
    private String description;
}
