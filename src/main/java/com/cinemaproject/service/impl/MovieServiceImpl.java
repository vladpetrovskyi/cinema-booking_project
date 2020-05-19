package com.cinemaproject.service.impl;

import com.cinemaproject.dao.MovieDao;
import com.cinemaproject.lib.Inject;
import com.cinemaproject.lib.Service;
import com.cinemaproject.model.Movie;
import com.cinemaproject.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Inject
    MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
