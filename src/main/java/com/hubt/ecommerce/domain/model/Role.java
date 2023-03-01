package com.hubt.ecommerce.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true,length = 50)
    private String role;

    public Role(String role_admin) {
        role = role_admin;
    }

    public Role(Integer roleId) {
        id = roleId;
    }

    @Override
    public String toString() {
        return role;
    }
}
