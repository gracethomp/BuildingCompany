package com.solvd.entity;

public class Client extends User{
    private City city;

    public Client(){}
    public Client(Long id, String email, String password, String firstName,
                  String lastName, String phoneNumber, UserStatus status, City city){
        super(id, email, password, firstName, lastName, phoneNumber, status);
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
