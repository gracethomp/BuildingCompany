package com.solvd;

import com.solvd.dao.mysql.UserDAO;
import com.solvd.exceptions.DAOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(UserDAO.getInstance().getByID(1L));
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
