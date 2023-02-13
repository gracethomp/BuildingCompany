package com.solvd.models;

public class Employee extends AbstractEmployee{
    public Employee(){}
    public Employee(Long id, String title, Double salary, Department department,
                    Boolean editUserRight, Boolean editBuildingRight, User user){
        super(id, title, salary, department, editUserRight, editBuildingRight, user);
    }
}
