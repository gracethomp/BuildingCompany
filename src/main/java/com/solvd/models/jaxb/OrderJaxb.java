package com.solvd.models.jaxb;

import com.solvd.models.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderJaxb {
    private Long id;
    private BuildingJaxb building;
    private EmployeeJaxb manager;
    private Double totalPrice;
    private OrderStatusJaxb status;

    public OrderJaxb() {
    }

    public OrderJaxb(Long id, BuildingJaxb building, EmployeeJaxb manager,
                     Double totalPrice, OrderStatusJaxb status) {
        this.id = id;
        this.building = building;
        this.manager = manager;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingJaxb getBuilding() {
        return building;
    }

    public void setBuilding(BuildingJaxb building) {
        this.building = building;
    }

    public EmployeeJaxb getManager() {
        return manager;
    }

    public void setManager(EmployeeJaxb manager) {
        this.manager = manager;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatusJaxb getStatus() {
        return status;
    }

    public void setStatus(OrderStatusJaxb status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderJaxb{" +
                "id=" + id +
                ", building=" + building +
                ", manager=" + manager +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }
}
