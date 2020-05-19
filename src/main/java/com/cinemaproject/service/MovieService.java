package com.cinemaproject.service;

import com.cinemaproject.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
