package com.cinema.security;

import com.cinema.model.Role;
import com.cinema.model.User;
import com.cinema.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        org.springframework.security.core.userdetails.User.UserBuilder builder;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(user.getPassword());
            builder.roles(user.getRoles().stream()
                    .map(Role::getRoleName)
                    .map(Enum::toString)
                    .toArray(String[]::new));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
