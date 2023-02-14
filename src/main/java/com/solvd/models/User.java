package com.solvd.models;

import com.solvd.models.abstractions.AbstractUser;

public class User extends AbstractUser {
    public User(){}
    public User(Long id, String email, String password, String firstName, String lastName,
                String phoneNumber, UserStatus status) {
        super(id, email, password, firstName, lastName, phoneNumber, status);
    }
}
