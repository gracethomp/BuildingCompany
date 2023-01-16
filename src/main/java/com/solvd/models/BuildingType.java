package com.solvd.models;

public class BuildingType extends Entity{
    private String typeName;

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
