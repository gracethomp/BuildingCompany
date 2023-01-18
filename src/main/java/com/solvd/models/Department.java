package com.solvd.models;

import java.util.ArrayList;
import java.util.List;

public class Department extends Entity {
    private String departmentName;
    private String phoneNumber;
    private List<Employee> employeeList = new ArrayList<>();;

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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
