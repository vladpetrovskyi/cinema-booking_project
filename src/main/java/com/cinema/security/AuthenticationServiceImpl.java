package com.cinema.security;

import com.cinema.exceptions.AuthenticationException;
import com.cinema.lib.Inject;
import com.cinema.lib.Service;
import com.cinema.model.User;
import com.cinema.service.UserService;
import com.cinema.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Inject
    private UserService userService;

    @Override
    public User login(String email, String pass) throws AuthenticationException {
        User userFromDb = userService.findByEmail(email);

        if (HashUtil.isValid(pass, userFromDb.getPassword(), userFromDb.getSalt())) {
            return userFromDb;
        }
        throw new AuthenticationException("Incorrect login or password");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        byte[] salt = HashUtil.getSalt();
        user.setPassword(HashUtil.hashPassword(user.getPassword(), salt));
        user.setSalt(salt);
        return userService.add(user);
    }
}
