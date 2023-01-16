package com.solvd.dao.mysql;

import com.solvd.dao.IApartmentDAO;
import com.solvd.models.Apartment;
import com.solvd.models.Building;
import com.solvd.utils.ConnectionPool;

import java.sql.*;

public class ApartmentDAO extends MySQL implements IApartmentDAO {
    @Override
    public Apartment getByID(Long id) {
        Apartment apartment = new Apartment();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buildCompany",
                    "root","root");
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from appartments where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                apartment = new Apartment((long) resultSet.getInt("id"), resultSet.getInt("rooms"),
                        resultSet.getInt("floor"), resultSet.getDouble("area"), new Building());
            }
            System.out.println(apartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Apartment entity) {

    }

    @Override
    public Apartment create(Apartment entity) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
