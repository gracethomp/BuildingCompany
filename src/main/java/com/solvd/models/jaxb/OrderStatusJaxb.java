package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class OrderStatusJaxb {
    private Long id;
    private String statusName;

    public OrderStatusJaxb() {
    }

    public OrderStatusJaxb(Long id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlValue
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "OrderStatusJaxb{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
