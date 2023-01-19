package com.solvd;

import com.solvd.dao.mysql.ApartmentDAO;
import com.solvd.dao.mysql.BuildingDAO;
import com.solvd.dao.mysql.UserDAO;
import com.solvd.exceptions.DAOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(ApartmentDAO.getInstance().getAllByBuildingID(2L));
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
