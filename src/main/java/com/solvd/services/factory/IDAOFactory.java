package com.solvd.services.factory;

import com.solvd.dao.*;

public interface IDAOFactory {
    IApartmentDAO getApartmentDAO();
    IBuildingOrderDAO getBuildingOrderDAO();
    IBuildingDAO getBuildingDAO();
    IBuildingTypeDAO getBuildingTypeDAO();
    ICityDAO getCityDAO();
    IClientDAO getClientDAO();
    IConstructionMaterialDAO getIConstructionMaterialDAO();
    IDepartmentDAO getDepartmentDAO();
    IEmployeeDAO getEmployeeDAO();
    IOrderStatusDAO getIOrderStatusDAO();
    IUserDAO getUserDAO();
    IUserStatusDAO getUserStatusDAO();
}
