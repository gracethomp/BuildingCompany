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
            client.setUser(user);
        }
        Node cityFromFile = document.getDocumentElement().getElementsByTagName("city").item(0);
        client.setCity(new City(Long.valueOf(cityFromFile.getAttributes().getNamedItem("id").getNodeValue()),
                cityFromFile.getTextContent()));
        NodeList buildingOrdersFromFile = document.getElementsByTagName("buildingOrder");
        List<BuildingOrder> buildingOrders = new ArrayList<>();
        for(int i = 0; i < buildingOrdersFromFile.getLength(); i++) {
            BuildingOrder buildingOrder = new BuildingOrder();
            Node buildingOrderFromFile = buildingOrdersFromFile.item(i);
            if (buildingOrderFromFile.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) buildingOrderFromFile;
                Node buildingFileName = element.getElementsByTagName("building").item(0);
                if(buildingFileName.getNodeType() == Node.ELEMENT_NODE){
                    Element element1 = (Element) buildingFileName;
                    Building building = new Building("", new BuildingType(Long.valueOf(element1.getElementsByTagName("type")
                            .item(0).getAttributes().getNamedItem("id").getNodeValue()), element1.
                            getElementsByTagName("type").item(0).getTextContent()),
                            Double.valueOf(element1.getElementsByTagName("area").item(0).getTextContent()),
                            Integer.valueOf(element1.getElementsByTagName("floors").item(0).getTextContent()),
                            new ConstructionMaterial(Long.valueOf(element1.getElementsByTagName("constructionMaterial")
                                    .item(0).getAttributes().getNamedItem("id").getNodeValue()), element1.
                                    getElementsByTagName("constructionMaterial").item(0).getTextContent()),
                            new City(Long.valueOf(element1.getElementsByTagName("cityBuilding").item(0).
                                    getAttributes().getNamedItem("id").getNodeValue()),
                                    element1.getElementsByTagName("cityBuilding").item(0).getTextContent()),
                            element1.getElementsByTagName("address").item(0).getTextContent());
                    building.setId(Long.valueOf(element.getAttribute("id")));
                    buildingOrder.setBuilding(building);
                }
            }
            buildingOrders.add(buildingOrder);
        }
        client.setBuildingOrders(buildingOrders);
        System.out.println(client);
    }
}
