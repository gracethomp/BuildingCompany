package com.solvd.dao.mysql;

import com.solvd.dao.IUserStatusDAO;
import com.solvd.models.*;
import com.solvd.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatusDAO extends MySQL implements IUserStatusDAO {
    private static final UserStatusDAO INSTANCE = new UserStatusDAO();

    private UserStatusDAO(){}

    public static UserStatusDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public UserStatus getByID(Long id) {
        UserStatus userStatus = new UserStatus();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from userStatuses where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userStatus = new UserStatus((long) resultSet.getInt("id"),
                        resultSet.getString("status"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userStatus;
    }

    @Override
    public void update(UserStatus userStatus) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE userStatuses SET status=? where id=?");
            preparedStatement.setString(1, userStatus.getStatusName());
            preparedStatement.setInt(2, userStatus.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public UserStatus create(UserStatus userStatus) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO userStatuses(status) VALUES ?");
            preparedStatement.setString(1, userStatus.getStatusName());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return userStatus;
    }

    @Override
    public void remove(Long id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from userStatuses where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
