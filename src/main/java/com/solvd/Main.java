package com.solvd;

import com.solvd.dao.*;
import com.solvd.models.Apartment;
import com.solvd.models.Building;
import com.solvd.models.OrderStatus;
import com.solvd.models.User;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.parsels.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException,
            SAXException, DAOException {
        ClientHandler.doParse();
        DOMExample.doParse();
        StAXParser.doParse();
        JaxbParser.doParse();
        JacksonParser.doParse();
        SqlSessionFactory sqlSessionFactory;
        Reader reader;
        reader = Resources.getResourceAsReader("mybatis_config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        IApartmentDAO apartmentDAO = session.getMapper(IApartmentDAO.class);
        IBuildingOrderDAO dao = session.getMapper(IBuildingOrderDAO.class);
        Apartment apartment = new Apartment();
        apartment.setArea(232.3);
        apartment.setFloor(2);
        apartment.setRooms(4);
        Building building = new Building();
        building.setId(2L);
        apartment.setBuilding(building);
        apartmentDAO.create(apartment);
        System.out.println(dao.getByID(3L));
        session.commit();
    }
}
