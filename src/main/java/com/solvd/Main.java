package com.solvd;

import com.solvd.dao.*;
import com.solvd.models.OrderStatus;
import com.solvd.models.User;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.parsels.*;
import org.apache.ibatis.io.Resources;
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
        IUserDAO userDAO = sqlSessionFactory.openSession().getMapper(IUserDAO.class);
        IBuildingOrderDAO dao = sqlSessionFactory.openSession().getMapper(IBuildingOrderDAO.class);
        User user = userDAO.getByID(1L);
        System.out.println(dao.getByID(3L));
    }
}
