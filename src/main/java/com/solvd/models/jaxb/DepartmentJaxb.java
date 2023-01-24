package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class DepartmentJaxb {
    private Long id;
    private String departmentName;

    public DepartmentJaxb() {
    }

    public DepartmentJaxb(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlValue
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentJaxb{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
