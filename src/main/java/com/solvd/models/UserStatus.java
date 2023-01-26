package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class UserStatus extends Entity{
    private String statusName;

    public UserStatus(){}
    public UserStatus(Long id, String statusName){
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
        return "UserStatus{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
