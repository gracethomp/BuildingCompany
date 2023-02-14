package com.solvd.models;

import com.solvd.models.abstractions.AbstractMaterial;

public class ConstructionMaterial extends AbstractMaterial {
    public ConstructionMaterial(){}
    public ConstructionMaterial(Long id, String material) {
        super(id, material);
    }
}
