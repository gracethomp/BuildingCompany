package com.solvd.utils.parsels;

import com.solvd.models.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends DefaultHandler {
    private final Client client = new Client();
    private User user;
    private UserStatus userStatus;
    private City city;
    private BuildingOrder buildingOrder;
    private Building building;
    private Employee employee;
    private OrderStatus orderStatus;
    private BuildingType buildingType;
    private ConstructionMaterial constructionMaterial;
    private Department department;
    private List<BuildingOrder> buildingOrders;
    private StringBuilder stringBuilder = new StringBuilder();

    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class);

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("start doc");
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("end doc");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "user", "userManager" -> {
                user = new User();
                user.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "userStatus" -> {
                userStatus = new UserStatus();
                stringBuilder = new StringBuilder();
                userStatus.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "city", "cityBuilding" -> {
                city = new City();
                stringBuilder = new StringBuilder();
                city.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "buildingOrders" -> buildingOrders = new ArrayList<>();
            case "buildingOrder" -> {
                buildingOrder = new BuildingOrder();
                buildingOrder.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "building" -> {
                building = new Building();
                building.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "manager" -> {
                employee = new Employee();
                employee.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "status" -> {
                orderStatus = new OrderStatus();
                stringBuilder = new StringBuilder();
                orderStatus.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "type" -> {
                buildingType = new BuildingType();
                stringBuilder = new StringBuilder();
                buildingType.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "constructionMaterial" -> {
                constructionMaterial = new ConstructionMaterial();
                stringBuilder = new StringBuilder();
                constructionMaterial.setId(Long.valueOf(attributes.getValue("id")));
            }
            case "department" -> {
                department = new Department();
                stringBuilder = new StringBuilder();
                department.setId(Long.valueOf(attributes.getValue("id")));
            }
            default -> stringBuilder = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "user" -> client.setUser(user);
            case "email" -> user.setEmail(stringBuilder.toString());
            case "password" -> user.setPassword(stringBuilder.toString());
            case "fName" -> user.setFirstName(stringBuilder.toString());
            case "lName" -> user.setLastName(stringBuilder.toString());
            case "phoneNumber" -> user.setPhoneNumber(stringBuilder.toString());
            case "userManager" -> employee.setUser(user);
            case "userStatus" -> {
                userStatus.setStatusName(stringBuilder.toString());
                user.setStatus(userStatus);
            }
            case "city" -> {
                city.setCityName(stringBuilder.toString());
                client.setCity(city);
            }
            case "cityBuilding" -> {
                city.setCityName(stringBuilder.toString());
                building.setCity(city);
            }
            case "buildingOrders" -> client.setBuildingOrders(buildingOrders);
            case "type" -> {
                buildingType.setTypeName(stringBuilder.toString());
                building.setType(buildingType);
            }
            case "area" -> building.setArea(Double.valueOf(stringBuilder.toString()));
            case "floors" -> building.setFloors(Integer.valueOf(stringBuilder.toString()));
            case "buildingOrder" -> buildingOrders.add(buildingOrder);
            case "building" -> buildingOrder.setBuilding(building);
            case "manager" -> buildingOrder.setManager(employee);
            case "status" -> {
                orderStatus.setStatusName(stringBuilder.toString());
                buildingOrder.setStatus(orderStatus);
            }
            case "constructionMaterial" -> {
                constructionMaterial.setMaterial(stringBuilder.toString());
                building.setMaterial(constructionMaterial);
            }
            case "address" -> building.setAddress(stringBuilder.toString());
            case "title" -> employee.setTitle(stringBuilder.toString());
            case "salary" -> employee.setSalary(Double.valueOf(stringBuilder.toString()));
            case "editUserRight" -> employee.setEditUserRight(Boolean.valueOf(stringBuilder.toString()));
            case "editBuildingRight" -> employee.setEditBuildingRight(Boolean.valueOf(stringBuilder.toString()));
            case "department" -> {
                department.setDepartmentName(stringBuilder.toString());
                employee.setDepartment(department);
            }
            case "totalPrice" -> buildingOrder.setTotalPrice(Double.valueOf(stringBuilder.toString()));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(new String(ch, start, length));
    }

    public Client getClient() {
        return client;
    }
}
