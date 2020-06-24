package com.cinema.model.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequestDto {
    @NotNull(message = "'title' field cannot be empty!")
    private String title;
    
    private String description;
}
