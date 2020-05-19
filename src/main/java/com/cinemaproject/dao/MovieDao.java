package com.cinemaproject.dao;

import com.cinemaproject.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();
}
