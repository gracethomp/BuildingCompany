package com.solvd.utils.parsels;

import com.solvd.models.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
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
        Client client = new Client();
        User user = new User();
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
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(building);
    }
}
