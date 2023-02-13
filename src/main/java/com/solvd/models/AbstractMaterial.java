package com.solvd.models;

public class AbstractMaterial extends Entity{
    private String material;

    public AbstractMaterial(){}
    public AbstractMaterial(Long id, String material) {
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
        return "Material{" +
                "material='" + material + '\'' +
                '}';
    }
}
