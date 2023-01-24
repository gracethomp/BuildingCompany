package com.solvd.utils.parsels;

import com.solvd.models.*;
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

    public static void doParse() throws ParserConfigurationException, IOException, SAXException {
        Client client = new Client();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/client.xml"));

        Node userFromFile = document.getDocumentElement().getElementsByTagName("user").item(0);
        User user = readUser(userFromFile);
        client.setUser(user);

        Node cityFromFile = document.getDocumentElement().getElementsByTagName("city").item(0);
        client.setCity(readCity(cityFromFile));
        NodeList buildingOrdersFromFile = document.getElementsByTagName("buildingOrder");
        List<BuildingOrder> buildingOrders = new ArrayList<>();
        for (int i = 0; i < buildingOrdersFromFile.getLength(); i++) {
            Node buildingOrderFromFile = buildingOrdersFromFile.item(i);
            Node userManagerFromFile = document.getDocumentElement().
                    getElementsByTagName("userManager").item(0);
            buildingOrders.add(readBuildingOrder(buildingOrderFromFile, userManagerFromFile));
        }
        client.setBuildingOrders(buildingOrders);
        System.out.println(client);
    }

    private static User readUser(Node userFromFile) {
        User user = new User();
        user.setId(Long.valueOf(userFromFile.getAttributes().getNamedItem("id").getNodeValue()));
        if (userFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) userFromFile;
            user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
            user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
            user.setPhoneNumber(element.getElementsByTagName("phoneNumber").item(0).getTextContent());
            user.setFirstName(element.getElementsByTagName("fName").item(0).getTextContent());
            user.setLastName(element.getElementsByTagName("lName").item(0).getTextContent());
            user.setStatus(new UserStatus(Long.valueOf(element.getElementsByTagName("userStatus").item(0)
                    .getAttributes().getNamedItem("id").getNodeValue()), element.getElementsByTagName("userStatus").
                    item(0).getTextContent()));
        }
        return user;
    }

    private static Department readDepartment(Node departmentFromFile) {
        return new Department(Long.valueOf(departmentFromFile.getAttributes().
                getNamedItem("id").getNodeValue()), departmentFromFile.getTextContent(), "");
    }
    private static Employee readEmployee(Element element, Node managerFromFile, Node userManagerFromFile) {
        Employee employee = new Employee();
        if (managerFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element1 = (Element) managerFromFile;
            employee = new Employee(Long.valueOf(element.getAttribute("id")),
                    element1.getElementsByTagName("title").item(0).getTextContent(),
                    Double.valueOf(element1.getElementsByTagName("salary").item(0).getTextContent()),
                    readDepartment(element1.getElementsByTagName("department").item(0)),
                    Boolean.valueOf(element1.getElementsByTagName("editUserRight")
                            .item(0).getTextContent()),
                    Boolean.valueOf(element1.getElementsByTagName("editUserRight")
                            .item(0).getTextContent()),
                    readUser(userManagerFromFile));
        }
        return employee;
    }
    private static Building readBuilding(Element element, Node buildingFileName) {
        Building building = new Building();
        if (buildingFileName.getNodeType() == Node.ELEMENT_NODE) {
            Element element1 = (Element) buildingFileName;
            building = new Building("", new BuildingType(Long.valueOf(element1.
                    getElementsByTagName("type").item(0).getAttributes().getNamedItem("id").getNodeValue()),
                    element1.getElementsByTagName("type").item(0).getTextContent()),
                    Double.valueOf(element1.getElementsByTagName("area").item(0).getTextContent()),
                    Integer.valueOf(element1.getElementsByTagName("floors").item(0).getTextContent()),
                    new ConstructionMaterial(Long.valueOf(element1.getElementsByTagName("constructionMaterial")
                            .item(0).getAttributes().getNamedItem("id").getNodeValue()), element1.
                            getElementsByTagName("constructionMaterial").item(0).getTextContent()),
                    readCity(element1.getElementsByTagName("cityBuilding").item(0)),
                    element1.getElementsByTagName("address").item(0).getTextContent());
            building.setId(Long.valueOf(element.getAttribute("id")));
        }
        return building;
    }

    private static City readCity(Node cityFromFile) {
        return new City(Long.valueOf(cityFromFile.getAttributes().getNamedItem("id").getNodeValue()),
                cityFromFile.getTextContent());
    }
    private static BuildingOrder readBuildingOrder(Node buildingOrderFromFile, Node userManagerFromFile) {
        BuildingOrder buildingOrder = new BuildingOrder();
        if (buildingOrderFromFile.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) buildingOrderFromFile;
            Node buildingFileName = element.getElementsByTagName("building").item(0);
            buildingOrder.setBuilding(readBuilding(element, buildingFileName));
            Node managerFromFile = element.getElementsByTagName("manager").item(0);
            buildingOrder.setManager(readEmployee(element, managerFromFile, userManagerFromFile));
            buildingOrder.setTotalPrice(Double.valueOf(element.getElementsByTagName("totalPrice")
                    .item(0).getTextContent()));
            buildingOrder.setStatus(new OrderStatus(Long.valueOf(element.getElementsByTagName("status")
                    .item(0).getAttributes().getNamedItem("id").getNodeValue()),
                    element.getElementsByTagName("status").item(0).getTextContent()));
        }
        return buildingOrder;
    }
}
