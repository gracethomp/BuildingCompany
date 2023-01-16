package com.solvd.entity;

public class City extends Entity{
    private String cityName;

    public City(){}
    public City(Long id, String cityName){
        super(id);
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
