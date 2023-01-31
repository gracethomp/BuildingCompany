package com.solvd.services.impl;

import com.solvd.dao.IDepartmentDAO;
import com.solvd.models.Department;
import com.solvd.services.IDepartmentService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class DepartmentService implements IDepartmentService {
    private final IDepartmentDAO departmentDAO = factory.getDepartmentDAO();
    @Override
    public Department getByID(Long id) throws ServiceException {
        try {
            return departmentDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Department entity) throws ServiceException {
        try {
            departmentDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(Department entity) throws ServiceException {
        try {
            departmentDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            departmentDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
