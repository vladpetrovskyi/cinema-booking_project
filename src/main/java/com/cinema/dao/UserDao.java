package com.cinema.dao;

import com.cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    User findByEmail(String email);

    Optional<User> getById(Long id);
}
