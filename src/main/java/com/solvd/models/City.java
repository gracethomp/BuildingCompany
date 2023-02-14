package com.solvd.models;

import com.solvd.models.abstractions.AbstractCity;

public class City extends AbstractCity {
    public City(){}
    public City(Long id, String cityName){
        super(id, cityName);
    }
}
