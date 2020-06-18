package com.cinema.service;

import com.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
