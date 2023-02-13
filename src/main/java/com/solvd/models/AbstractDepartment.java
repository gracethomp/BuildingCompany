package com.solvd.models;

public class AbstractDepartment extends Entity{
    private String departmentName;
    private String phoneNumber;

    public AbstractDepartment(){}
    public AbstractDepartment(Long id, String departmentName, String phoneNumber) {
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


    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
