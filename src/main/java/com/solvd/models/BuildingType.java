package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class BuildingType extends Entity{
    private String typeName;
    private List<Building> buildings = new ArrayList<>();

    public BuildingType(){}
    public BuildingType(Long id, String typeName){
        super(id);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
