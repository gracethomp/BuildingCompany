package com.solvd.models.abstractions;

import com.solvd.models.Department;
import com.solvd.models.User;

public abstract class AbstractEmployee extends Entity{
    private String title;
    private Double salary;
    private AbstractDepartment department;
    private Boolean editUserRight;
    private Boolean editBuildingRight;
    private AbstractUser user;

    public AbstractEmployee(){}
    public AbstractEmployee(Long id, String title, Double salary, Department department,
                    Boolean editUserRight, Boolean editBuildingRight, User user){
        super(id);
        this.title = title;
        this.salary = salary;
        this.department = department;
        this.editUserRight = editUserRight;
        this.editBuildingRight = editBuildingRight;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public Double getSalary() {
        return salary;
    }

    public AbstractDepartment getDepartment() {
        return department;
    }

    public Boolean getEditBuildingRight() {
        return editBuildingRight;
    }

    public Boolean getEditUserRight() {
        return editUserRight;
    }

    public AbstractUser getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "title='" + title + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", editUserRight=" + editUserRight +
                ", editBuildingRight=" + editBuildingRight +
                ", user=" + user +
                '}';
    }
}
