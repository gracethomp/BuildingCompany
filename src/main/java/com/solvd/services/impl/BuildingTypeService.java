package com.solvd.services.impl;

import com.solvd.dao.IBuildingTypeDAO;
import com.solvd.models.BuildingType;
import com.solvd.services.IBuildingTypeService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class BuildingTypeService implements IBuildingTypeService {
    private final IBuildingTypeDAO buildingTypeDAO = factory.getBuildingTypeDAO();
    @Override
    public BuildingType getByID(Long id) throws ServiceException {
        try {
            return buildingTypeDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(BuildingType entity) throws ServiceException {
        try {
            buildingTypeDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(BuildingType entity) throws ServiceException {
        try {
            buildingTypeDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            buildingTypeDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
