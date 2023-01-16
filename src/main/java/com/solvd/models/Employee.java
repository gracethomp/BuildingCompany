package com.solvd.models;

public class Employee extends User{
    private String title;
    private Double salary;
    private Department department;
    private Boolean editUserRight;
    private Boolean editBuildingRight;

    public Employee(){}
    public Employee(String title, Double salary, Department department, Boolean editUserRight, Boolean editBuildingRight){
        this.title = title;
        this.salary = salary;
        this.department = department;
        this.editUserRight = editUserRight;
        this.editBuildingRight = editBuildingRight;
    }

    public String getTitle() {
        return title;
    }

    public Double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public Boolean getEditBuildingRight() {
        return editBuildingRight;
    }

    public Boolean getEditUserRight() {
        return editUserRight;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setEditUserRight(Boolean editUserRight) {
        this.editUserRight = editUserRight;
    }

    public void setEditBuildingRight(Boolean editBuildingRight) {
        this.editBuildingRight = editBuildingRight;
    }
}
