package com.solvd.services.impl;

import com.solvd.dao.IBuildingOrderDAO;
import com.solvd.models.BuildingOrder;
import com.solvd.services.IBuildingOrderService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class BuildingOrderService implements IBuildingOrderService {
    private final IBuildingOrderDAO buildingOrderDAO = factory.getBuildingOrderDAO();

    @Override
    public BuildingOrder getByID(Long id) throws ServiceException {
        try {
            return buildingOrderDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(BuildingOrder entity) throws ServiceException {
        try {
            buildingOrderDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(BuildingOrder entity) throws ServiceException {
        try {
            buildingOrderDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            buildingOrderDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
