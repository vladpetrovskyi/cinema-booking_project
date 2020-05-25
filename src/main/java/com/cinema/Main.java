package com.cinema;

import com.cinema.exceptions.AuthenticationException;
import com.cinema.lib.Injector;
import com.cinema.model.CinemaHall;
import com.cinema.model.Movie;
import com.cinema.model.MovieSession;
import com.cinema.model.User;
import com.cinema.security.AuthenticationService;
import com.cinema.service.CinemaHallService;
import com.cinema.service.MovieService;
import com.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.cinema");

    public static void main(String[] args) throws AuthenticationException {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        movieService.add(movie);

        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService =
                (CinemaHallService) INJECTOR.getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(175);
        cinemaHallService.add(cinemaHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 45)));
        MovieSessionService movieSessionService =
                (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);

        movieSessionService.findAvailableSessions(movie.getId(), LocalDate.now())
                .forEach(System.out::println);

        User user1 = new User();
        user1.setEmail("sasha.dovgyi@gmail.com");
        user1.setPassword("12345");
        User user2 = new User();
        user2.setEmail("anton.pavlov@i.ua");
        user2.setPassword("1111");

        AuthenticationService authenticationService =
                (AuthenticationService) INJECTOR.getInstance(AuthenticationService.class);
        authenticationService.register("sasha.dovgyi@gmail.com", "12345");
        authenticationService.register("anton.pavlov@i.ua", "1111");
        authenticationService.login("sasha.dovgyi@gmail.com", "12345");
        authenticationService.login("sasha.dovgy@gmail.com", "12345");
        authenticationService.login("sasha.dovgyi@gmail.com", "1234");
    }
}
