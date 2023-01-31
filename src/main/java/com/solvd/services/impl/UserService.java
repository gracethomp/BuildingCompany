package com.solvd.services.impl;

import com.solvd.dao.IUserDAO;
import com.solvd.models.User;
import com.solvd.services.IUserService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class UserService implements IUserService {
    private final IUserDAO userDAO = factory.getUserDAO();
    @Override
    public User getByID(Long id) throws ServiceException {
        try {
            return userDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(User entity) throws ServiceException {
        try {
            userDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(User entity) throws ServiceException {
        try {
            userDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            userDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
