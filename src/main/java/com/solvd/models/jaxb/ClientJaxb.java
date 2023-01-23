package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "client")
public class ClientJaxb {
    private CityJaxb city;
    private UserJaxb user;
    private List<OrderJaxb> orders;

    public ClientJaxb() {
    }

    public ClientJaxb(CityJaxb city, List<OrderJaxb> orders) {
        this.city = city;
        this.orders = orders;
    }

    @XmlElement
    public CityJaxb getCity() {
        return city;
    }
    @XmlElementWrapper(name = "buildingOrders")
    @XmlElement(name = "buildingOrder")
    public List<OrderJaxb> getOrders() {
        return orders;
    }

    public void setCity(CityJaxb city) {
        this.city = city;
    }

    public void setOrders(List<OrderJaxb> orders) {
        this.orders = orders;
    }

    public UserJaxb getUser() {
        return user;
    }

    public void setUser(UserJaxb user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClientJaxb{" +
                "city=" + city +
                ", user=" + user +
                ", orders=" + orders +
                '}';
    }
}
