package com.ukukhula.bursaryapi.entities;

import lombok.Data;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int contactId;
    private int userRoleId;
    private boolean isUserActive;

    public User(int id, String firstName, String lastName, int contactId, int userRoleId, boolean isUserActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactId = contactId;
        this.userRoleId = userRoleId;
        this.isUserActive = isUserActive;
    }
}
