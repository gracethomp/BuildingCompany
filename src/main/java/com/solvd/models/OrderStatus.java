package com.solvd.models;

import com.solvd.models.abstractions.AbstractStatus;

public class OrderStatus extends AbstractStatus {
    public OrderStatus(){}
    public OrderStatus(Long id, String statusName) {
        super(id, statusName);
    }
}
