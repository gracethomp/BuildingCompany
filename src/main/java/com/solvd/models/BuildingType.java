package com.solvd.models;

import com.solvd.models.abstractions.AbstractType;

public class BuildingType extends AbstractType {
    public BuildingType(){}
    public BuildingType(Long id, String typeName){
        super(id, typeName);
    }
}
