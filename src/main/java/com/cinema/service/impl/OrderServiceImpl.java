package com.cinema.service.impl;

import com.cinema.dao.OrderDao;
import com.cinema.dao.ShoppingCartDao;
import com.cinema.lib.Inject;
import com.cinema.lib.Service;
import com.cinema.model.Order;
import com.cinema.model.ShoppingCart;
import com.cinema.model.Ticket;
import com.cinema.model.User;
import com.cinema.service.OrderService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDao orderDao;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Order completeOrder(List<Ticket> tickets, User user) {
        Order order = new Order();
        order.setTickets(tickets);
        order.setUser(user);
        order.setOrderTime(LocalDateTime.now().withNano(0));
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.findByUser(user);
    }
}
