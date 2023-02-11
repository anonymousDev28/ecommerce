package com.hubt.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
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
