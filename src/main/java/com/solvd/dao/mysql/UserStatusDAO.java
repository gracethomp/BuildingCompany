package com.solvd.dao.mysql;

import com.solvd.dao.IUserStatusDAO;
import com.solvd.exceptions.ConnectionPoolException;
import com.solvd.exceptions.DAOException;
import com.solvd.models.*;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatusDAO extends MySQL implements IUserStatusDAO {
    private static final UserStatusDAO INSTANCE = new UserStatusDAO();

    private static final Logger LOGGER = Logger.getLogger(UserStatusDAO.class);

    private UserStatusDAO(){}

    public static UserStatusDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public UserStatus getByID(Long id) throws DAOException {
        UserStatus userStatus = new UserStatus();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * from userStatuses where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userStatus = new UserStatus((long) resultSet.getInt("id"),
                        resultSet.getString("status"));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userStatus;
    }

    @Override
    public void update(UserStatus userStatus) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE userStatuses SET status=? where id=?");
            preparedStatement.setString(1, userStatus.getStatusName());
            preparedStatement.setInt(2, userStatus.getId().intValue());
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
    public UserStatus create(UserStatus userStatus) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO userStatuses(status) VALUES ?");
            preparedStatement.setString(1, userStatus.getStatusName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userStatus;
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from userStatuses where id =?");
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
