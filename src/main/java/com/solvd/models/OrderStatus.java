package com.solvd.models;

public class OrderStatus extends Entity{
    private String statusName;

    public OrderStatus(){}
    public OrderStatus(Long id, String statusName) {
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
        return "OrderStatus{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
