package com.cinema.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequestDto {
    @NotNull(message = "'userId' field cannot be empty!")
    @Min(value = 1, message = "User ID cannot be less than 1!")
    private Long userId;
}
