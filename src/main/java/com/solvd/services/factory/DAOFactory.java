package com.solvd.services.factory;

public class DAOFactory {
    public static IDAOFactory getFactory(String db) {
        return switch (db) {
            case "mySQL" -> DAOFactoryMySQL.getInstance();
            case "myBatis" -> DAOFactoryMyBatis.getInstance();
            default -> throw new IllegalStateException("Unexpected value: " + db);
        };
    }
}

