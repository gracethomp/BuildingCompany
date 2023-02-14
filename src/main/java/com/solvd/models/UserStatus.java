package com.solvd.models;

import com.solvd.models.abstractions.AbstractStatus;

public class UserStatus extends AbstractStatus {
    public UserStatus(){}
    public UserStatus(Long id, String statusName){
        super(id, statusName);
    }
}
