package com.solvd.entity;

public class ConstructionMaterial extends Entity{
    private String material;

    public ConstructionMaterial(){}
    public ConstructionMaterial(Long id, String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
