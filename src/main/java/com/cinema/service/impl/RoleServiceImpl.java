package com.cinema.service.impl;

import com.cinema.dao.RoleDao;
import com.cinema.model.Role;
import com.cinema.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getByName(roleName).orElseThrow();
    }
}
