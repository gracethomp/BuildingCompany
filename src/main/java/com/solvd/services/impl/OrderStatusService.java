package com.solvd.services.impl;

import com.solvd.dao.IOrderStatusDAO;
import com.solvd.models.OrderStatus;
import com.solvd.services.IOrderStatusService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class OrderStatusService implements IOrderStatusService {
    private final IOrderStatusDAO orderStatusDAO = factory.getIOrderStatusDAO();
    @Override
    public OrderStatus getByID(Long id) throws ServiceException {
        try {
            return orderStatusDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(OrderStatus entity) throws ServiceException {
        try {
            orderStatusDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(OrderStatus entity) throws ServiceException {
        try {
            orderStatusDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            orderStatusDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
