package com.solvd.dao;

import com.solvd.utils.exceptions.DAOException;

public interface IBaseDAO<T> {
    T getByID(Long id) throws DAOException;
    void update(T entity) throws DAOException;
    T create(T entity) throws DAOException;
    void remove(Long id) throws DAOException;
}
