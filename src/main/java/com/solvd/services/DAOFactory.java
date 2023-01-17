package com.solvd.services;

public class DAOFactory {
    public static IDAOFactory getFactory(String db) {
        return switch (db) {
            case "mySQL" -> new DAOFactoryMySQL();
            default -> throw new IllegalStateException("Unexpected value: " + db);
        };
    }
}

