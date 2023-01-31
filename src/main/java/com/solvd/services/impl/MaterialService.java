package com.solvd.services.impl;

import com.solvd.dao.IConstructionMaterialDAO;
import com.solvd.models.ConstructionMaterial;
import com.solvd.services.IMaterialService;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.utils.exceptions.ServiceException;

public class MaterialService implements IMaterialService {
    private final IConstructionMaterialDAO constructionMaterialDAO = factory.getIConstructionMaterialDAO();
    @Override
    public ConstructionMaterial getByID(Long id) throws ServiceException {
        try {
            return constructionMaterialDAO.getByID(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void update(ConstructionMaterial entity) throws ServiceException {
        try {
            constructionMaterialDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void create(ConstructionMaterial entity) throws ServiceException {
        try {
            constructionMaterialDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    @Override
    public void remove(Long id) throws ServiceException {
        try {
            constructionMaterialDAO.remove(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
