package com.solvd.dao;

import com.solvd.models.User;
import com.solvd.utils.exceptions.DAOException;

public interface IUserDAO extends IBaseDAO<User> {
    @Override
    User getByID(Long id) throws DAOException;
}
