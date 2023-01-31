package com.solvd.services.impl;

import com.solvd.dao.IBuildingDAO;
import com.solvd.models.Building;
import com.solvd.services.IBuildingService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class BuildingService implements IBuildingService {
    private final IBuildingDAO buildingDAO = factory.getBuildingDAO();
    @Override
    public Building getByID(Long id) throws ServiceException {
        try {
            return buildingDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Building entity) throws ServiceException {
        try {
            buildingDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(Building entity) throws ServiceException {
        try {
            buildingDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            buildingDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
