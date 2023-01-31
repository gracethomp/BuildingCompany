package com.solvd.services.impl;

import com.solvd.dao.IClientDAO;
import com.solvd.models.Client;
import com.solvd.services.IClientService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class ClientService implements IClientService {
    private final IClientDAO clientDAO = factory.getClientDAO();
    @Override
    public Client getByID(Long id) throws ServiceException {
        try {
            return clientDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Client entity) throws ServiceException {
        try {
            clientDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(Client entity) throws ServiceException {
        try {
            clientDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            clientDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
