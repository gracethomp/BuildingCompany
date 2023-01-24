package com.solvd.models.jackson;

public class Employee {
    private Long id;
    private String title;
    private Double salary;
    private Boolean editUserRight;
    private Boolean editBuildingRight;
    private User user;

    public Employee() {
    }

    public Employee(Long id, String title, Double salary, Boolean editUserRight,
                    Boolean editBuildingRight, User user) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.editUserRight = editUserRight;
        this.editBuildingRight = editBuildingRight;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", editUserRight=" + editUserRight +
                ", editBuildingRight=" + editBuildingRight +
                '}';
    }
}