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
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ItemMapper<Order, OrderRequestDto, OrderResponseDto> itemMapper;

    @GetMapping
    public List<OrderResponseDto> getUserOrders(Authentication auth) {
        List<Order> orderList =
                orderService.getOrderHistory(userService.findByEmail(getUserEmail(auth)));
        return orderList.stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping(value = "/complete")
    public void completeOrder(Authentication auth) {
        User user = userService.findByEmail(getUserEmail(auth));
        orderService.completeOrder(shoppingCartService.getByUser(user).getTickets(), user);
    }

    private String getUserEmail(Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return principal.getUsername();
    }
}
