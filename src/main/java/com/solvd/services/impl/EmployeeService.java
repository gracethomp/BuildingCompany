package com.solvd.services.impl;

import com.solvd.dao.IEmployeeDAO;
import com.solvd.models.Employee;
import com.solvd.services.IEmployeeService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeDAO employeeDAO = factory.getEmployeeDAO();
    @Override
    public Employee getByID(Long id) throws ServiceException {
        try {
            return employeeDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(Employee entity) throws ServiceException {
        try {
            employeeDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(Employee entity) throws ServiceException {
        try {
            employeeDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            employeeDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
