package com.solvd.entity;

public class BuildingOrder extends Entity{
    private Building building;
    private Client client;
    private Employee manager;
    private Double totalPrice;
    private Apartment apartment;
    private OrderStatus status;

    public BuildingOrder(){}
    public BuildingOrder(Long id, Building building, Client client, Employee manager,
                         Double totalPrice, OrderStatus status){
        super(id);
        this.building = building;
        this.client = client;
        this.manager = manager;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public BuildingOrder(Long id, Building building, Client client, Employee manager,
                         Double totalPrice, OrderStatus status, Apartment apartment){
        super(id);
        this.building = building;
        this.client = client;
        this.manager = manager;
        this.totalPrice = totalPrice;
        this.status = status;
        this.apartment = apartment;
    }

    public Building getBuilding() {
        return building;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Client getClient() {
        return client;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Employee getManager() {
        return manager;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
