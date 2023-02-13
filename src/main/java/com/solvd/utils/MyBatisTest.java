package com.solvd.utils;

import com.solvd.dao.IBuildingDAO;
import com.solvd.dao.IBuildingOrderDAO;
import com.solvd.models.Building;
import com.solvd.models.BuildingType;
import com.solvd.models.City;
import com.solvd.models.ConstructionMaterial;
import com.solvd.utils.exceptions.DAOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisTest {
    public static void doTest() throws IOException, DAOException {
        SqlSessionFactory sqlSessionFactory;
        Reader reader;
        reader = Resources.getResourceAsReader("mybatis_config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        IBuildingDAO apartmentDAO = session.getMapper(IBuildingDAO.class);
        IBuildingOrderDAO dao = session.getMapper(IBuildingOrderDAO.class);
        Building building = new Building();
        building.setAddress("fdsfsdfdsf/232g");
        building.setArea(32432.34);
        building.setFloors(4);
        ConstructionMaterial material = new ConstructionMaterial();
        material.setId(1L);
        building.setMaterial(material);
        City city = new City();
        BuildingType type = new BuildingType();
        building.setId(26L);
        type.setId(1L);
        city.setId(2L);
        building.setCity(city);
        building.setType(type);
        building.setBuildingName("NAME");
        apartmentDAO.remove(26L);
        System.out.println(dao.getByID(3L));
        session.commit();
    }
}
