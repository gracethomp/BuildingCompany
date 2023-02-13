package com.solvd.models;

public abstract class AbstractStatus extends Entity {
    private String statusName;

    public AbstractStatus(){}
    public AbstractStatus(Long id, String statusName){
        super(id);
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "AbstractStatus{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
