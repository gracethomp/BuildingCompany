package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class Building extends Entity{
    private String buildingName;
    private BuildingType type;
    private Double area;
    private Integer floors;
    private ConstructionMaterial material;
    private City city;
    private String address;
    private List<Apartment> apartments = new ArrayList<>();
    private List<BuildingOrder> buildingOrders = new ArrayList<>();

    public Building(){}
    public Building(String buildingName, BuildingType type, Double area, Integer floors,
                    ConstructionMaterial material, City city, String address){
        this.buildingName = buildingName;
        this.type = type;
        this.area = area;
        this.floors = floors;
        this.material = material;
        this.city = city;
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public BuildingType getType() {
        return type;
    }

    public ConstructionMaterial getMaterial() {
        return material;
    }

    public Double getArea() {
        return area;
    }

    public Integer getFloors() {
        return floors;
    }

    public String getAddress() {
        return address;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public List<BuildingOrder> getBuildingOrders() {
        return buildingOrders;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setMaterial(ConstructionMaterial material) {
        this.material = material;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public void setBuildingOrders(List<BuildingOrder> buildingOrders) {
        this.buildingOrders = buildingOrders;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Building{" +
                "type=" + type +
                ", area=" + area +
                ", floors=" + floors +
                ", material=" + material +
                ", city=" + city +
                ", address='" + address + '\'' +
                '}';
    }
}
