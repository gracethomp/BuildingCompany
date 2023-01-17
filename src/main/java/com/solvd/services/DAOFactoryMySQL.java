package com.solvd.services;

import com.solvd.dao.*;
import com.solvd.dao.mysql.*;

public class DAOFactoryMySQL implements IDAOFactory{
    @Override
    public IApartmentDAO getApartmentDAO() {
        return ApartmentDAO.getInstance();
    }

    @Override
    public IBuildingOrderDAO getBuildingOrderDAO() {
        return BuildingOrderDAO.getInstance();
    }

    @Override
    public IBuildingDAO getBuildingDAO() {
        return BuildingDAO.getInstance();
    }

    @Override
    public IBuildingTypeDAO getBuildingTypeDAO() {
        return BuildingTypeDAO.getInstance();
    }

    @Override
    public ICityDAO getCityDAO() {
        return CityDAO.getInstance();
    }

    @Override
    public IClientDAO getClientDAO() {
        return ClientDAO.getInstance();
    }

    @Override
    public IConstructionMaterialDAO getIConstructionMaterialDAO() {
        return ConstructionMaterialDAO.getInstance();
    }

    @Override
    public IDepartmentDAO getDepartmentDAO() {
        return DepartmentDAO.getInstance();
    }

    @Override
    public IEmployeeDAO getEmployeeDAO() {
        return EmployeeDAO.getInstance();
    }

    @Override
    public IOrderStatusDAO getIOrderStatusDAO() {
        return OrderStatusDAO.getInstance();
    }

    @Override
    public IUserDAO getUserDAO() {
        return UserDAO.getInstance();
    }

    @Override
    public IUserStatusDAO getUserStatusDAO() {
        return UserStatusDAO.getInstance();
    }
}
