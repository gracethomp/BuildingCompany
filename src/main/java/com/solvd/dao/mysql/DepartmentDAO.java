package com.solvd.dao.mysql;

import com.solvd.dao.IDepartmentDAO;
import com.solvd.models.Department;
import com.solvd.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO extends MySQL implements IDepartmentDAO {
    private static final DepartmentDAO INSTANCE = new DepartmentDAO();

    private DepartmentDAO(){}

    public static DepartmentDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Department getByID(Long id) {
        Department department = new Department();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from departments where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department = new Department((long) resultSet.getInt("id"),
                        resultSet.getString("department"), resultSet.getString("phoneNumber"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return department;
    }

    @Override
    public void update(Department department) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE departments SET department=?, phoneNumber=? where id=?");
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getPhoneNumber());
            preparedStatement.setInt(3, department.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public Department create(Department department) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO departments(department, phoneNumber) VALUES (?,?)");
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return department;
    }

    @Override
    public void remove(Long id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from departments where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
