package com.solvd.models;

public class Apartment extends Entity{
    private Integer rooms;
    private Integer floor;
    private Double area;
    private Building building;

    public Apartment(){}
    public Apartment(Long id, Integer room, Integer floor, Double area, Building building){
        super(id);
        this.rooms = room;
        this.floor = floor;
        this.area = area;
        this.building = building;
    }

    public Double getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "room=" + rooms +
                ", floor=" + floor +
                ", area=" + area +
                ", building=" + building +
                '}';
    }
}
