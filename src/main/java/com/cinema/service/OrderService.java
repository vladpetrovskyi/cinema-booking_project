package com.cinema.service;

import com.cinema.model.Order;
import com.cinema.model.Ticket;
import com.cinema.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(List<Ticket> tickets, User user);

    List<Order> getOrderHistory(User user);
}
