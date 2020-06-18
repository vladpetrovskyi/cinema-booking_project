package com.cinema.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role() {
    }

    private Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public static Role of(String role) {
        return new Role(RoleName.valueOf(role));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public enum RoleName {
        ADMIN, USER
    }
}
