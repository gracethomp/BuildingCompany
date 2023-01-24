package com.solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.models.jackson.Department;
import com.solvd.utils.parsels.ClientHandler;
import com.solvd.utils.parsels.DOMExample;
import com.solvd.utils.parsels.JaxbParser;
import com.solvd.utils.parsels.StAXParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws JAXBException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ClientHandler handler = new ClientHandler();
            saxParser.parse(new File("src/main/resources/client.xml"), handler);
            LOGGER.info(handler.getClient());
            DOMExample.doParse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error(e);
        }
        StAXParser.doParse();
        System.out.println();
        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/department.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Department department = objectMapper.readValue(jsonData, Department.class);

        LOGGER.info(department);
    }
}
