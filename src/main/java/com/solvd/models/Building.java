package com.solvd.models;

public class Building extends AbstractBuilding{
    public Building(){}
    public Building(String buildingName, BuildingType type, Double area, Integer floors,
                    ConstructionMaterial material, City city, String address){
        super(buildingName, type, area, floors, material, city, address);
    }
}
