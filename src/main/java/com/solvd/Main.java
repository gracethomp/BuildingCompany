package com.solvd;

import com.solvd.dao.mysql.ApartmentDAO;
import com.solvd.utils.parsels.ClientHandler;
import com.solvd.utils.parsels.DOMExample;
import com.solvd.utils.parsels.StAXParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ClientHandler handler = new ClientHandler();
            saxParser.parse(new File("src/main/resources/client.xml"), handler);
            LOGGER.info(handler.getClient());
            DOMExample.doParse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        StAXParser.doParse();
    }
}
