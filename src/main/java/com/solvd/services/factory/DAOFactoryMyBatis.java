package com.solvd.services.factory;

import com.solvd.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DAOFactoryMyBatis implements IDAOFactory{
    private static final DAOFactoryMyBatis INSTANCE = new DAOFactoryMyBatis();
    private SqlSession session;

    private DAOFactoryMyBatis(){
        SqlSessionFactory sqlSessionFactory;
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis_config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DAOFactoryMyBatis getInstance() {
        return INSTANCE;
    }


    @Override
    public IApartmentDAO getApartmentDAO() {
        return session.getMapper(IApartmentDAO.class);
    }

    @Override
    public IBuildingOrderDAO getBuildingOrderDAO() {
        return session.getMapper(IBuildingOrderDAO.class);
    }

    @Override
    public IBuildingDAO getBuildingDAO() {
        return session.getMapper(IBuildingDAO.class);
    }

    @Override
    public IBuildingTypeDAO getBuildingTypeDAO() {
        return session.getMapper(IBuildingTypeDAO.class);
    }

    @Override
    public ICityDAO getCityDAO() {
        return session.getMapper(ICityDAO.class);
    }

    @Override
    public IClientDAO getClientDAO() {
        return session.getMapper(IClientDAO.class);
    }

    @Override
    public IConstructionMaterialDAO getIConstructionMaterialDAO() {
        return session.getMapper(IConstructionMaterialDAO.class);
    }

    @Override
    public IDepartmentDAO getDepartmentDAO() {
        return session.getMapper(IDepartmentDAO.class);
    }

    @Override
    public IEmployeeDAO getEmployeeDAO() {
        return session.getMapper(IEmployeeDAO.class);
    }

    @Override
    public IOrderStatusDAO getIOrderStatusDAO() {
        return session.getMapper(IOrderStatusDAO.class);
    }

    @Override
    public IUserDAO getUserDAO() {
        return session.getMapper(IUserDAO.class);
    }

    @Override
    public IUserStatusDAO getUserStatusDAO() {
        return session.getMapper(IUserStatusDAO.class);
    }
}
