package com.cinema.model.dto.response;

public class CinemaHallResponseDto {
    private Long cinemaHallId;
    private Long capacity;
    private String details;

    public Long getId() {
        return cinemaHallId;
    }

    public void setId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return details;
    }

    public void setDescription(String details) {
        this.details = details;
    }
}
