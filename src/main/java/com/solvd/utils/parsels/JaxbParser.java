package com.solvd.utils.parsels;

import com.solvd.models.jaxb.ClientJaxb;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser {
    private static final Logger LOGGER = Logger.getLogger(JaxbParser.class);

    public static void doParse() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ClientJaxb.class);
        Unmarshaller jaxbUnmarshaller;
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ClientJaxb client= (ClientJaxb) jaxbUnmarshaller.unmarshal(new File(XMLConfiguration.FILE.getValue()));
        System.out.println();
        LOGGER.info(client);
    }
}
