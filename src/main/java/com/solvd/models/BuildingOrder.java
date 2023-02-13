package com.solvd.models;

public class BuildingOrder extends Entity{
    private AbstractBuilding building;
    private AbstractClient client;
    private AbstractEmployee manager;
    private Double totalPrice;
    private AbstractApartment apartment;
    private AbstractStatus status;

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

    public AbstractBuilding getBuilding() {
        return building;
    }

    public AbstractApartment getApartment() {
        return apartment;
    }

    public AbstractClient getClient() {
        return client;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public AbstractEmployee getManager() {
        return manager;
    }

    public AbstractStatus getStatus() {
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

    @Override
    public String toString() {
        return "BuildingOrder{" +
                "building=" + building +
                ", manager=" + manager +
                ", totalPrice=" + totalPrice +
                ", apartment=" + apartment +
                ", status=" + status +
                '}';
    }
}
