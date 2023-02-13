package com.solvd.utils.parsels;

import com.solvd.models.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMExample {
    private static final Logger LOGGER = Logger.getLogger(DOMExample.class);

    public static void doParse() throws ParserConfigurationException, IOException, SAXException {
        Client client = new Client();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XMLConfiguration.FILE.getValue()));

        Node userFromFile = document.getDocumentElement().
                getElementsByTagName(XMLConfiguration.USER.getValue()).item(0);
        User user = readUser(userFromFile);
        client.setUser(user);

        Node cityFromFile = document.getDocumentElement().
                getElementsByTagName(XMLConfiguration.CITY.getValue()).item(0);
        client.setCity(readCity(cityFromFile));
        NodeList buildingOrdersFromFile = document.getElementsByTagName(XMLConfiguration.BUILDING_ORDER.getValue());
        List<BuildingOrder> buildingOrders = new ArrayList<>();
        for (int i = 0; i < buildingOrdersFromFile.getLength(); i++) {
            Node buildingOrderFromFile = buildingOrdersFromFile.item(i);
            Node userManagerFromFile = document.getDocumentElement().
                    getElementsByTagName(XMLConfiguration.USER_MANAGER.getValue()).item(0);
            buildingOrders.add(readBuildingOrder(buildingOrderFromFile, userManagerFromFile));
        }
        client.setBuildingOrders(buildingOrders);
        System.out.println();
        LOGGER.info(client);
    }

    private static User readUser(Node userFromFile) {
        User user = new User();
        user.setId(Long.valueOf(userFromFile.getAttributes().
                getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()));
        if (userFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) userFromFile;
            user.setEmail(element.getElementsByTagName(XMLConfiguration.EMAIL.getValue()).
                    item(0).getTextContent());
            user.setPassword(element.getElementsByTagName(XMLConfiguration.PASSWORD.getValue()).
                    item(0).getTextContent());
            user.setPhoneNumber(element.getElementsByTagName(XMLConfiguration.PHONE_NUMBER.getValue()).
                    item(0).getTextContent());
            user.setFirstName(element.getElementsByTagName(XMLConfiguration.FIRST_NAME.getValue()).
                    item(0).getTextContent());
            user.setLastName(element.getElementsByTagName(XMLConfiguration.LAST_NAME.getValue()).
                    item(0).getTextContent());
            user.setStatus(new UserStatus(Long.valueOf(element.
                    getElementsByTagName(XMLConfiguration.USER_STATUS.getValue()).item(0)
                    .getAttributes().getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()),
                    element.getElementsByTagName(XMLConfiguration.USER_STATUS.getValue()).
                            item(0).getTextContent()));
        }
        return user;
    }

    private static Department readDepartment(Node departmentFromFile) {
        return new Department(Long.valueOf(departmentFromFile.getAttributes().
                getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()), departmentFromFile.getTextContent(), "");
    }
    private static Employee readEmployee(Element element, Node managerFromFile, Node userManagerFromFile) {
        Employee employee = new Employee();
        if (managerFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element1 = (Element) managerFromFile;
            employee = new Employee(Long.valueOf(element.getAttribute(XMLConfiguration.ID.getValue())),
                    element1.getElementsByTagName(XMLConfiguration.TITLE.getValue()).item(0).getTextContent(),
                    Double.valueOf(element1.
                            getElementsByTagName(XMLConfiguration.SALARY.getValue()).item(0).getTextContent()),
                    readDepartment(element1.getElementsByTagName(XMLConfiguration.DEPARTMENT.getValue()).
                            item(0)), Boolean.valueOf(element1.
                    getElementsByTagName(XMLConfiguration.EDIT_USER_RIGHTS.getValue()).item(0).getTextContent()),
                    Boolean.valueOf(element1.getElementsByTagName(XMLConfiguration.EDIT_BUILDING_RIGHTS.getValue()).
                            item(0).getTextContent()), readUser(userManagerFromFile));
        }
        return employee;
    }
    private static Building readBuilding(Element element, Node buildingFileName) {
        Building building = new Building();
        if (buildingFileName.getNodeType() == Node.ELEMENT_NODE) {
            Element element1 = (Element) buildingFileName;
            building = new Building("", new BuildingType(Long.valueOf(element1.
                    getElementsByTagName(XMLConfiguration.TYPE.getValue()).item(0).getAttributes().
                    getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()), element1.
                    getElementsByTagName(XMLConfiguration.TYPE.getValue()).item(0).getTextContent()),
                    Double.valueOf(element1.getElementsByTagName(XMLConfiguration.AREA.getValue()).
                            item(0).getTextContent()), Integer.valueOf(element1.
                    getElementsByTagName(XMLConfiguration.FLOORS.getValue()).item(0).getTextContent()),
                    new ConstructionMaterial(Long.valueOf(element1.
                            getElementsByTagName(XMLConfiguration.MATERIAL.getValue()).item(0).
                            getAttributes().getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()),
                            element1.getElementsByTagName(XMLConfiguration.MATERIAL.getValue()).
                                    item(0).getTextContent()), readCity(element1.
                    getElementsByTagName(XMLConfiguration.CITY_BUILDING.getValue()).item(0)),
                    element1.getElementsByTagName(XMLConfiguration.ADDRESS.getValue()).item(0).getTextContent());
            building.setId(Long.valueOf(element.getAttribute(XMLConfiguration.ID.getValue())));
        }
        return building;
    }

    private static City readCity(Node cityFromFile) {
        return new City(Long.valueOf(cityFromFile.getAttributes().
                getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()),
                cityFromFile.getTextContent());
    }

    private static BuildingOrder readBuildingOrder(Node buildingOrderFromFile, Node userManagerFromFile) {
        BuildingOrder buildingOrder = new BuildingOrder();
        if (buildingOrderFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) buildingOrderFromFile;
            Node buildingFileName = element.getElementsByTagName(XMLConfiguration.BUILDING.getValue()).item(0);
            buildingOrder.setBuilding(readBuilding(element, buildingFileName));
            Node managerFromFile = element.getElementsByTagName(XMLConfiguration.MANAGER.getValue()).item(0);
            buildingOrder.setManager(readEmployee(element, managerFromFile, userManagerFromFile));
            buildingOrder.setTotalPrice(Double.valueOf(element.
                    getElementsByTagName(XMLConfiguration.TOTAL_PRICE.getValue()).item(0).getTextContent()));
            buildingOrder.setStatus(new OrderStatus(Long.valueOf(element.
                    getElementsByTagName(XMLConfiguration.STATUS.getValue()).item(0).getAttributes().
                    getNamedItem(XMLConfiguration.ID.getValue()).getNodeValue()), element.
                    getElementsByTagName(XMLConfiguration.STATUS.getValue()).item(0).getTextContent()));
        }
        return buildingOrder;
    }
}
