package com.cinema.controllers;

import com.cinema.model.Order;
import com.cinema.model.User;
import com.cinema.model.dto.request.OrderRequestDto;
import com.cinema.model.dto.response.OrderResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.OrderService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ItemMapper<Order, OrderRequestDto, OrderResponseDto> itemMapper;

    public OrderController(OrderService orderService,
                           UserService userService,
                           ItemMapper<Order, OrderRequestDto, OrderResponseDto> itemMapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.itemMapper = itemMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> getUserOrders(@PathVariable Long userId) {
        List<Order> orderList = orderService.getOrderHistory(userService.getById(userId));
        return orderList.stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping(value = "/{userId}/complete")
    public void completeOrder(@PathVariable Long userId) {
        User user = userService.getById(userId);
        orderService.completeOrder(shoppingCartService.getByUser(user).getTickets(), user);
    }
}
