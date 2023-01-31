package com.solvd.services.impl;

import com.solvd.dao.IUserStatusDAO;
import com.solvd.models.UserStatus;
import com.solvd.services.IUserStatusService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class UserStatusService implements IUserStatusService {
    private final IUserStatusDAO userStatusDAO = factory.getUserStatusDAO();
    @Override
    public UserStatus getByID(Long id) throws ServiceException {
        try {
            return userStatusDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(UserStatus entity) throws ServiceException {
        try {
            userStatusDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(UserStatus entity) throws ServiceException {
        try {
            userStatusDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            userStatusDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
