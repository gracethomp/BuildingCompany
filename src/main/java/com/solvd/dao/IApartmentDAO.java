package com.solvd.dao;

import com.solvd.exceptions.DAOException;
import com.solvd.models.Apartment;

import java.util.List;

public interface IApartmentDAO extends IBaseDAO<Apartment> {
    List<Apartment> getAllByBuildingID(Long id) throws DAOException;
}
