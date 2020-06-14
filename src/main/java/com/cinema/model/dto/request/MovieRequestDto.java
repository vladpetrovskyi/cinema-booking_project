package com.cinema.model.dto.request;

import javax.validation.constraints.NotNull;

public class MovieRequestDto {
    @NotNull(message = "'title' field cannot be empty!")
    private String title;
    private String description;

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
