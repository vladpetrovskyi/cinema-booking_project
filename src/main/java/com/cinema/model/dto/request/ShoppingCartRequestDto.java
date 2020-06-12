package com.cinema.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ShoppingCartRequestDto {
    @NotNull
    @Min(value = 1)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
