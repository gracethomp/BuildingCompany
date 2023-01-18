package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class Client extends Entity{
    private City city;
    private User user;
    private List<BuildingOrder> buildingOrders = new ArrayList<>();

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

    public List<BuildingOrder> getBuildingOrders() {
        return buildingOrders;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBuildingOrders(List<BuildingOrder> buildingOrders) {
        this.buildingOrders = buildingOrders;
    }
}
