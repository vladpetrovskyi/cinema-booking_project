package com.cinema.service.impl;

import com.cinema.dao.MovieSessionDao;
import com.cinema.model.MovieSession;
import com.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieSessionServiceImpl implements MovieSessionService {

    private final MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession getById(Long id) {
        return movieSessionDao.getById(id).orElseThrow();
    }
}
