package com.cinema.service.impl;

import com.cinema.dao.UserDao;
import com.cinema.model.User;
import com.cinema.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id).orElseThrow();
    }
}
