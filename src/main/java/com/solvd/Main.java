package com.solvd;

import com.solvd.dao.mysql.ApartmentDAO;

public class Main {
    public static void main(String[] args) {
        ApartmentDAO apartmentDAO = new ApartmentDAO();
        apartmentDAO.getByID(1L);
    }
}
