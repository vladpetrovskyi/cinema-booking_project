package com.cinema.security;

import com.cinema.exceptions.AuthenticationException;
import com.cinema.model.User;
import com.cinema.service.ShoppingCartService;
import com.cinema.service.UserService;
import com.cinema.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    private final ShoppingCartService shoppingCartService;

    private final HashUtil hashUtil;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService, HashUtil hashUtil) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.hashUtil = hashUtil;
    }

    @Override
    public User login(String email, String pass) throws AuthenticationException {
        User userFromDb = userService.findByEmail(email);
        if (userFromDb != null
                && hashUtil.isValid(pass, userFromDb.getPassword(), userFromDb.getSalt())) {
            return userFromDb;
        }
        throw new AuthenticationException("Incorrect login or password");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        byte[] salt = hashUtil.getSalt();
        user.setPassword(hashUtil.hashPassword(password, salt));
        user.setSalt(salt);
        User userFromDb = userService.add(user);
        shoppingCartService.registerNewShoppingCart(userFromDb);
        return userFromDb;
    }
}
