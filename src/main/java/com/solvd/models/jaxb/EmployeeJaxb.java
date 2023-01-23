package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeJaxb {
    private String title;
    private Double salary;
    private DepartmentJaxb department;
    private Boolean editUserRight;
    private Boolean editBuildingRight;
    private UserJaxb user;

    public EmployeeJaxb() {
    }

    public EmployeeJaxb(String title, Double salary, DepartmentJaxb department,
                        Boolean editUserRight, Boolean editBuildingRight, UserJaxb user) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public DepartmentJaxb getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentJaxb department) {
        this.department = department;
    }

    public Boolean getEditUserRight() {
        return editUserRight;
    }

    public void setEditUserRight(Boolean editUserRight) {
        this.editUserRight = editUserRight;
    }

    public Boolean getEditBuildingRight() {
        return editBuildingRight;
    }

    public void setEditBuildingRight(Boolean editBuildingRight) {
        this.editBuildingRight = editBuildingRight;
    }

    public UserJaxb getUser() {
        return user;
    }

    public void setUser(UserJaxb user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmployeeJaxb{" +
                "title='" + title + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", editUserRight=" + editUserRight +
                ", editBuildingRight=" + editBuildingRight +
                ", user=" + user +
                '}';
    }
}
