package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus extends Entity{
    private String statusName;
    private List<BuildingOrder> buildingOrders = new ArrayList<>();

    public OrderStatus(){}
    public OrderStatus(Long id, String statusName) {
        super(id);
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public List<BuildingOrder> getBuildingOrders() {
        return buildingOrders;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public void setBuildingOrders(List<BuildingOrder> buildingOrders) {
        this.buildingOrders = buildingOrders;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
