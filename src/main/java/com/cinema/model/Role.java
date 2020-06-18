package com.cinema.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    private Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public static Role of(String role) {
        return new Role(RoleName.valueOf(role));
    }

    public enum RoleName {
        ADMIN, USER
    }
}
