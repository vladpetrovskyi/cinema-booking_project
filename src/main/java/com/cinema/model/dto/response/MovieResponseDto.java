package com.cinema.model.dto.response;

public class MovieResponseDto {
    private Long movieId;
    private String title;
    private String description;

    public Long getId() {
        return movieId;
    }

    public void setId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
