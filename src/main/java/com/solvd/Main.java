package com.solvd;

import com.solvd.utils.parsels.ClientHandler;
import com.solvd.utils.parsels.DOMExample;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ClientHandler handler = new ClientHandler();
            saxParser.parse(new File("src/main/resources/client.xml"), handler);
            System.out.println(handler.getClient());
            DOMExample.doParse();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
