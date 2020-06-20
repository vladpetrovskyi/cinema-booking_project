package com.cinema.service.impl;

import com.cinema.dao.CinemaHallDao;
import com.cinema.model.CinemaHall;
import com.cinema.service.CinemaHallService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }

    @Override
    public CinemaHall getById(Long id) {
        return cinemaHallDao.getById(id).orElseThrow();
    }
}
