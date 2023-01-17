package com.solvd.dao.mysql;

import com.solvd.dao.IClientDAO;
import com.solvd.models.Client;
import com.solvd.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends MySQL implements IClientDAO {
    private static final ClientDAO INSTANCE = new ClientDAO();

    private ClientDAO(){}

    public static ClientDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Client getByID(Long id) {
        Client client = new Client();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from clients where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client((long) resultSet.getInt("id"),
                        CityDAO.getInstance().getByID((long) resultSet.getInt("city_id")),
                        UserDAO.getInstance().getByID((long) resultSet.getInt("userId")));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return client;
    }

    @Override
    public void update(Client client) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE clients SET userId=?, city_id=? where id=?");
            preparedStatement.setInt(1, client.getUser().getId().intValue());
            preparedStatement.setInt(2, client.getCity().getId().intValue());
            preparedStatement.setInt(3, client.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public Client create(Client client) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO clients(userId, city_id) VALUES (?,?)");
            preparedStatement.setInt(1, client.getUser().getId().intValue());
            preparedStatement.setInt(2, client.getCity().getId().intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return client;
    }

    @Override
    public void remove(Long id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from clients where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
