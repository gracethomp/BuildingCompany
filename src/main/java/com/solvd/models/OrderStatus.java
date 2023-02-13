package com.solvd.models;

public class OrderStatus extends AbstractStatus{
    public OrderStatus(){}
    public OrderStatus(Long id, String statusName) {
        super(id, statusName);
    }
}
