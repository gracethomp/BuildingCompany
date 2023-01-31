package com.solvd.services.impl;

import com.solvd.dao.ICityDAO;
import com.solvd.models.City;
import com.solvd.services.ICityService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class CityService implements ICityService {
    private final ICityDAO cityDAO = factory.getCityDAO();
    @Override
    public City getByID(Long id) throws ServiceException {
        try {
            return cityDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(City entity) throws ServiceException {
        try {
            cityDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(City entity) throws ServiceException {
        try {
            cityDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            cityDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
