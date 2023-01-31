package com.solvd.services;

import com.solvd.services.factory.DAOFactory;
import com.solvd.services.factory.IDAOFactory;
import com.solvd.utils.exceptions.ServiceException;

public interface IBaseService <T> {
    IDAOFactory factory = DAOFactory.getFactory("myBatis");
    T getByID(Long id) throws ServiceException;
    void update(T entity) throws ServiceException;
    void create(T entity) throws ServiceException;
    void remove(Long id) throws ServiceException;
}
