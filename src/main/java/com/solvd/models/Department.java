package com.solvd.models;

public class Department extends Entity {
    private String departmentName;
    private String phoneNumber;

    public Department(){}
    public Department(Long id, String departmentName, String phoneNumber) {
        super(id);
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
