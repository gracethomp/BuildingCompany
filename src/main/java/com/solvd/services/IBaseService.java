package com.solvd.services;

import com.solvd.utils.exceptions.ServiceException;

public interface IBaseService <T> {
    T getByID(Long id) throws ServiceException;
    void update(T entity) throws ServiceException;
    void create(T entity) throws ServiceException;
    void remove(Long id) throws ServiceException;
}
