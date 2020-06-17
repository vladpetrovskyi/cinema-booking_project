package com.cinema.controllers;

import com.cinema.model.Role;
import com.cinema.model.User;
import com.cinema.service.RoleService;
import com.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class InjectDataController {

    private final RoleService roleService;
    private final UserService userService;

    public InjectDataController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void injectData() {
        roleService.add(Role.of("USER"));
        roleService.add(Role.of("ADMIN"));
        User user = new User();
        user.setEmail("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        userService.add(user);
    }
}
