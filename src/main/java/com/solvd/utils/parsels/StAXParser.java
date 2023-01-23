package com.solvd.utils.parsels;

import com.solvd.models.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    public static void doParse() {
        List<BuildingOrder> buildingOrders = new ArrayList<>();
        Building building = new Building();
        Employee employee = new Employee();
        Client client = new Client();
        User user = new User();
        StringBuilder stringBuilder = new StringBuilder();
        BuildingOrder buildingOrder = new BuildingOrder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.
                    createXMLEventReader(new FileInputStream("src/main/resources/client.xml"));
            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                if(event.isStartElement()){
                    StartElement startElement = event.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "user", "userManager" -> {
                            user = new User();
                            Attribute attribute = startElement.getAttributeByName(new QName("id"));
                            user.setId(Long.valueOf(attribute.getValue()));
                        }
                        case "userStatus" -> user.setStatus(new UserStatus(Long.valueOf(startElement.
                                getAttributeByName(new QName("id")).getValue()),
                                xmlEventReader.nextEvent().asCharacters().getData()));
                        case "city" -> client.setCity(new City(Long.valueOf(startElement.
                                getAttributeByName(new QName("id")).getValue()), xmlEventReader.
                                nextEvent().asCharacters().getData()));
                        case "cityBuilding" -> building.setCity(new City(Long.valueOf(startElement.
                                getAttributeByName(new QName("id")).getValue()), xmlEventReader.
                                nextEvent().asCharacters().getData()));
                        case "buildingOrder" -> {
                            buildingOrder = new BuildingOrder();
                            buildingOrder.setId(Long.valueOf(startElement.
                                getAttributeByName(new QName("id")).getValue()));
                        }
                        case "building" -> {
                            building = new Building();
                            building.setId(Long.valueOf(startElement.
                                    getAttributeByName(new QName("id")).getValue()));
                        }
                        case "constructionMaterial" -> building.setMaterial(new ConstructionMaterial(Long.
                                valueOf(startElement.getAttributeByName(new QName("id")).getValue()),
                                xmlEventReader.nextEvent().asCharacters().getData()));
                        case "type" -> building.setType(new BuildingType(Long.
                                valueOf(startElement.getAttributeByName(new QName("id")).getValue()),
                                xmlEventReader.nextEvent().asCharacters().getData()));
                        case "manager" -> {
                            employee = new Employee();
                            employee.setId(Long.valueOf(startElement.
                                    getAttributeByName(new QName("id")).getValue()));
                            buildingOrder.setManager(employee);
                        }
                        case "department" -> {
                            Department department = new Department();
                            department.setDepartmentName(xmlEventReader.nextEvent().asCharacters().getData());
                            department.setId(Long.valueOf(startElement.
                                    getAttributeByName(new QName("id")).getValue()));
                            employee.setDepartment(department);
                        }
                        case "status" -> buildingOrder.setStatus(new OrderStatus(Long.valueOf(startElement.
                                getAttributeByName(new QName("id")).getValue()), xmlEventReader.
                                nextEvent().asCharacters().getData()));
                        default -> stringBuilder = new StringBuilder(xmlEventReader.
                                nextEvent().asCharacters().getData());
                    }
                }
                if(event.isEndElement()) {
                    EndElement element = event.asEndElement();
                    switch (element.getName().getLocalPart()) {
                        case "user" -> client.setUser(user);
                        case "email" -> user.setEmail(stringBuilder.toString());
                        case "password" -> user.setPassword(stringBuilder.toString());
                        case "fName" -> user.setFirstName(stringBuilder.toString());
                        case "lName" -> user.setLastName(stringBuilder.toString());
                        case "phoneNumber" -> user.setPhoneNumber(stringBuilder.toString());
                        case "building" -> buildingOrder.setBuilding(building);
                        case "buildingOrder" -> buildingOrders.add(buildingOrder);
                        case "buildingOrders" -> client.setBuildingOrders(buildingOrders);
                        case "area" -> building.setArea(Double.valueOf(stringBuilder.toString()));
                        case "floors" -> building.setFloors(Integer.valueOf(stringBuilder.toString()));
                        case "address" -> building.setAddress(stringBuilder.toString());
                        case "title" -> employee.setTitle(stringBuilder.toString());
                        case "salary" -> employee.setSalary(Double.valueOf(stringBuilder.toString()));
                        case "editUserRight" -> employee.setEditUserRight(Boolean.valueOf(stringBuilder.toString()));
                        case "editBuildingRight" -> employee.setEditBuildingRight(Boolean.
                                valueOf(stringBuilder.toString()));
                        case "totalPrice" -> buildingOrder.setTotalPrice(Double.valueOf(stringBuilder.toString()));
                        case "userManager" -> employee.setUser(user);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(client);
    }
}
