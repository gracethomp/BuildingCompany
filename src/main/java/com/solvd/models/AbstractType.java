package com.solvd.models;

public abstract class AbstractType extends Entity{
    private String typeName;

    public AbstractType(){}
    public AbstractType(Long id, String typeName){
        super(id);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "AbstractType{" +
                "typeName='" + typeName + '}';
    }
}
