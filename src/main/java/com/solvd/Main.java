package com.solvd;

import com.solvd.utils.MyBatisTest;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.parsels.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException,
            SAXException, DAOException {
        ParsingProcess.doParse();
        DOMExample.doParse();
        StAXParser.doParse();
        JaxbParser.doParse();
        JacksonParser.doParse();
        MyBatisTest.doTest();
    }
}
