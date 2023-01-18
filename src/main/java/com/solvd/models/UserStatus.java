package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class UserStatus extends Entity{
    private String statusName;
    private List<User> users = new ArrayList<>();;

    public UserStatus(){}
    public UserStatus(Long id, String statusName){
        super(id);
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "statusName='" + statusName + '\'' +
                '}';
    }
}
