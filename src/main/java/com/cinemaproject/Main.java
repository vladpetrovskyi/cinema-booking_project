package com.cinemaproject;

import com.cinemaproject.lib.Injector;
import com.cinemaproject.model.Movie;
import com.cinemaproject.service.MovieService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.cinemaproject");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);
    }
}
