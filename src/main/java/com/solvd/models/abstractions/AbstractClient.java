package com.solvd.models.abstractions;

import com.solvd.models.BuildingOrder;
import com.solvd.models.City;
import com.solvd.models.User;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClient extends Entity{
    private AbstractCity city;
    private AbstractUser user;
    private List<BuildingOrder> buildingOrders = new ArrayList<>();

    public AbstractClient(){}
    public AbstractClient(Long id, City city, User user){
        super(id);
        this.city = city;
        this.user = user;
    }

    public Long getId() {
        return super.getId();
    }
    public AbstractCity getCity() {
        return city;
    }
    public AbstractUser getUser() {
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

    @Override
    public String toString() {
        return "Client{" +
                "city=" + city +
                ", user=" + user +
                ", buildingOrders=" + buildingOrders +
                '}';
    }
}
