package com.solvd.utils.parsels;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParsingProcess {
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class);
    public static void doParse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ClientHandler handler = new ClientHandler();
            saxParser.parse(new File(XMLConfiguration.FILE.getValue()), handler);
            LOGGER.info(handler.getClient());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error(e);
        }
    }
}
