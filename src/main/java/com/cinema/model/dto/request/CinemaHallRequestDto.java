package com.cinema.model.dto.request;

import javax.validation.constraints.NotNull;

public class CinemaHallRequestDto {
    @NotNull(message = "'capacity' field can't be empty!")
    private Long capacity;
    private String description;

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
