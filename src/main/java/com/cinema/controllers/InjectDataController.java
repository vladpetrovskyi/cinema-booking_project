package com.cinema.controllers;

import com.cinema.model.Role;
import com.cinema.model.User;
import com.cinema.service.RoleService;
import com.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class InjectDataController {

    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void injectData() {
        roleService.add(Role.of("USER"));
        roleService.add(Role.of("ADMIN"));

        User admin = new User();
        admin.setEmail("admin@cinema.net");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        admin.setRoles(Set.of(roleService.getRoleByName("ADMIN")));

        User user = new User();
        user.setEmail("user@cinema.net");
        user.setPassword(new BCryptPasswordEncoder().encode("user1"));
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        userService.add(user);
    }
}
