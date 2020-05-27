package com.cinema.service;

import com.cinema.model.MovieSession;
import com.cinema.model.ShoppingCart;
import com.cinema.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
