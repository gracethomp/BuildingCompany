package com.solvd;

import com.solvd.dao.mysql.UserDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println(UserDAO.getInstance().getByID(1L));
    }
}
