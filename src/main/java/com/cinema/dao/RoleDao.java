package com.cinema.dao;

import com.cinema.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}
