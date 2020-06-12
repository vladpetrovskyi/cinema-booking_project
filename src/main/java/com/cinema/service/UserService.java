package com.cinema.service;

import com.cinema.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    User getById(Long id);
}
