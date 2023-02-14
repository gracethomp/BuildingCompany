package com.solvd.models;

import com.solvd.models.abstractions.AbstractApartment;

public class Apartment extends AbstractApartment {
    public Apartment(){}
    public Apartment(Long id, Integer room, Integer floor, Double area, Building building){
        super(id, room, floor, area, building);
    }
}
