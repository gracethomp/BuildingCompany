package com.solvd.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class City {
    private Long id;
    private String cityName;
    private List<Building> buildingList = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public City(){}
    public City(Long id, String cityName){
        this.id = id;
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }
    @XmlValue
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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' + '}';
    }
}
