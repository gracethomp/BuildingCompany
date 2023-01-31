package com.solvd.services.impl;

import com.solvd.dao.IApartmentDAO;
import com.solvd.models.Apartment;
import com.solvd.services.IApartmentService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class ApartmentService implements IApartmentService {
    private final IApartmentDAO apartmentDAO = factory.getApartmentDAO();

    @Override
    public Apartment getByID(Long id) throws ServiceException {
        try {
            return apartmentDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Apartment entity) throws ServiceException {
        try {
            apartmentDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(Apartment entity) throws ServiceException {
        try {
            apartmentDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            apartmentDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
