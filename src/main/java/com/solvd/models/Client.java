package com.solvd.models;

public class Client extends Entity{
    private City city;
    private User user;

    public Client(){}
    public Client(Long id, City city, User user){
        super(id);
        this.city = city;
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public User getUser() {
        return user;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
