package com.solvd.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class City extends Entity{
    private String cityName;

    public City(){}
    public City(Long id, String cityName){
        super(id);
        this.cityName = cityName;
    }

    @XmlValue
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' + '}';
    }
}
