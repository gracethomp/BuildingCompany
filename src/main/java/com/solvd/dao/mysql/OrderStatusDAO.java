package com.solvd.dao.mysql;

import com.solvd.dao.IOrderStatusDAO;
import com.solvd.exceptions.ConnectionPoolException;
import com.solvd.exceptions.DAOException;
import com.solvd.models.OrderStatus;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStatusDAO extends MySQL implements IOrderStatusDAO {
    private static final OrderStatusDAO INSTANCE = new OrderStatusDAO();

    private static final Logger LOGGER = Logger.getLogger(OrderStatusDAO.class);

    private OrderStatusDAO(){}

    public static OrderStatusDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public OrderStatus getByID(Long id) throws DAOException {
        OrderStatus orderStatus = new OrderStatus();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from orderStatuses where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderStatus = new OrderStatus((long) resultSet.getInt("id"),
                        resultSet.getString("status"));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return orderStatus;
    }

    @Override
    public void update(OrderStatus orderStatus) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE orderStatuses SET status=? where id=?");
            preparedStatement.setString(1, orderStatus.getStatusName());
            preparedStatement.setInt(2, orderStatus.getId().intValue());
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
    public OrderStatus create(OrderStatus orderStatus) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO orderStatuses(status) VALUES ?");
            preparedStatement.setString(1, orderStatus.getStatusName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return orderStatus;
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from orderStatuses where id =?");
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
