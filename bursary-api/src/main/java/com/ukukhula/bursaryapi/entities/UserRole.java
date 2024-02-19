package com.ukukhula.bursaryapi.entities;

import lombok.Data;

@Data
public class Role {
    private int id;
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }
}
