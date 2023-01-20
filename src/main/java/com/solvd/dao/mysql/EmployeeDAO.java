package com.solvd.dao.mysql;

import com.solvd.dao.IEmployeeDAO;
import com.solvd.utils.exceptions.ConnectionPoolException;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.models.Employee;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends MySQL implements IEmployeeDAO {
    private static final EmployeeDAO INSTANCE = new EmployeeDAO();

    private static final Logger LOGGER = Logger.getLogger(EmployeeDAO.class);

    private EmployeeDAO(){}

    public static EmployeeDAO getInstance() {
        return INSTANCE;
    }
    @Override
    public Employee getByID(Long id) throws DAOException {
        Employee employee = new Employee();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from employees where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee((long) resultSet.getInt("id"),
                        resultSet.getString("title"), resultSet.getDouble("salary"),
                        DepartmentDAO.getInstance().getByID((long) resultSet.getInt("department_id")),
                        resultSet.getBoolean("editUserRight"),
                        resultSet.getBoolean("editBuildingRight"),
                        UserDAO.getInstance().getByID((long) resultSet.getInt("user_id")));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE employees SET title=?, salary=?,department_id=?,user_id=?," +
                            "editUserRight=?, editBuildingRight=? where id=?");
            preparedStatement.setString(1, employee.getTitle());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getDepartment().getId().intValue());
            preparedStatement.setInt(4, employee.getUser().getId().intValue());
            preparedStatement.setBoolean(5, employee.getEditUserRight());
            preparedStatement.setBoolean(6, employee.getEditBuildingRight());
            preparedStatement.setInt(7, employee.getId().intValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public Employee create(Employee employee) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO employees(title, salary, department_id, user_id, " +
                            "editUserRight, editBuildingRight) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, employee.getTitle());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getDepartment().getId().intValue());
            preparedStatement.setInt(4, employee.getUser().getId().intValue());
            preparedStatement.setBoolean(5, employee.getEditUserRight());
            preparedStatement.setBoolean(6, employee.getEditBuildingRight());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return employee;
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from employees where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
