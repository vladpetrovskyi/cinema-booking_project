package com.cinema;

import com.cinema.lib.Injector;
import com.cinema.model.Movie;
import com.cinema.service.MovieService;

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
