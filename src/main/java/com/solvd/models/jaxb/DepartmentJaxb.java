package com.solvd.models.jaxb;

public class DepartmentJaxb {
    private Long id;
    private String departmentName;
    private String phoneNumber;

    public DepartmentJaxb() {
    }

    public DepartmentJaxb(Long id, String departmentName, String phoneNumber) {
        this.id = id;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "DepartmentJaxb{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
