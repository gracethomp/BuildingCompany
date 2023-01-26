package com.solvd.models;

public class ConstructionMaterial extends Entity{
    private String material;

    public ConstructionMaterial(){}
    public ConstructionMaterial(Long id, String material) {
        super(id);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ConstructionMaterial{" +
                "material='" + material + '\'' +
                '}';
    }
}
