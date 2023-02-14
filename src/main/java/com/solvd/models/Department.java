package com.solvd.models;

import com.solvd.models.abstractions.AbstractDepartment;

public class Department extends AbstractDepartment {
    public Department(){}
    public Department(Long id, String departmentName, String phoneNumber) {
        super(id, departmentName, phoneNumber);
    }
}
