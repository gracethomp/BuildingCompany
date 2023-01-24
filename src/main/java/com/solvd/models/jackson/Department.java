package com.solvd.models.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Department {
    private Long id;
    @JsonProperty("department")
    private String departmentName;
    private String phoneNumber;
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String departmentName, String phoneNumber, List<Employee> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employees=" + employees +
                '}';
    }
}
