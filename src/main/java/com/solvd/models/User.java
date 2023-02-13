package com.solvd.models;

public class User extends AbstractUser{
    public User(){}
    public User(Long id, String email, String password, String firstName, String lastName,
                String phoneNumber, UserStatus status) {
        super(id, email, password, firstName, lastName, phoneNumber, status);
    }
}
