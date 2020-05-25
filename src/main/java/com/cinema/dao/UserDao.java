package com.cinema.dao;

import com.cinema.model.User;

public interface UserDao {
    User add(User user);

    User findByEmail(String email);
}
