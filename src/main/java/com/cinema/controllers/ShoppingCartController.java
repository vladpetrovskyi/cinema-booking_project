package com.cinema.controllers;

import com.cinema.model.ShoppingCart;
import com.cinema.model.dto.request.ShoppingCartRequestDto;
import com.cinema.model.dto.response.ShoppingCartResponseDto;
import com.cinema.model.mapper.ItemMapper;
import com.cinema.service.MovieSessionService;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ItemMapper<ShoppingCart,
            ShoppingCartRequestDto, ShoppingCartResponseDto> itemMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService, ItemMapper<ShoppingCart,
            ShoppingCartRequestDto, ShoppingCartResponseDto> itemMapper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.itemMapper = itemMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping(value = "/by-user")
    public ShoppingCartResponseDto getShoppingCartByUserId(@RequestParam Long userId) {
        return itemMapper.toDto(shoppingCartService.getByUser(userService.getById(userId)));
    }

    @PostMapping(value = "/add-movie-session")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(
                movieSessionService.getById(movieSessionId),
                userService.getById(userId));
    }
}
