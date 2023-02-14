package com.solvd.models;

import com.solvd.models.abstractions.AbstractClient;

public class Client extends AbstractClient {
    public Client(){}
    public Client(Long id, City city, User user){
        super(id, city, user);
    }
}
