package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class City extends Entity{
    private String cityName;
    private List<Building> buildingList = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public City(){}
    public City(Long id, String cityName){
        super(id);
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' + '}';
    }
}
