package com.solvd.models;

public class Client extends AbstractClient{
    public Client(){}
    public Client(Long id, City city, User user){
        super(id, city, user);
    }
}
