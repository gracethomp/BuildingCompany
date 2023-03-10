package com.solvd.dao.mysql;

import com.solvd.dao.IBuildingOrderDAO;
import com.solvd.utils.exceptions.ConnectionPoolException;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.models.BuildingOrder;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingOrderDAO extends MySQL implements IBuildingOrderDAO {
    private static final BuildingOrderDAO INSTANCE = new BuildingOrderDAO();

    private static final Logger LOGGER = Logger.getLogger(BuildingOrderDAO.class);

    private BuildingOrderDAO(){}

    public static BuildingOrderDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public BuildingOrder getByID(Long id) throws DAOException {
        BuildingOrder buildingOrder = new BuildingOrder();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from buildingOrders where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buildingOrder = new BuildingOrder((long) resultSet.getInt("id"),
                        BuildingDAO.getInstance().getByID((long) resultSet.getInt("building_id")),
                        ClientDAO.getInstance().getByID((long) resultSet.getInt("client_id")),
                        EmployeeDAO.getInstance().getByID((long) resultSet.getInt("manager_id")),
                        resultSet.getDouble("totalPrice"),  OrderStatusDAO.getInstance()
                        .getByID((long) resultSet.getInt("status_id")),ApartmentDAO.getInstance()
                        .getByID((long) resultSet.getInt("appartment_id")));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return buildingOrder;
    }

    @Override
    public void update(BuildingOrder buildingOrder) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE buildingOrders SET building_id=?,client_id=?,totalPrice=?," +
                            "appartment_id=?, manager_id=?, status_id=? where id=?");
            preparedStatement.setInt(1, buildingOrder.getBuilding().getId().intValue());
            preparedStatement.setInt(2, buildingOrder.getClient().getId().intValue());
            preparedStatement.setDouble(3, buildingOrder.getTotalPrice());
            preparedStatement.setInt(4, buildingOrder.getApartment().getId().intValue());
            preparedStatement.setInt(5, buildingOrder.getManager().getId().intValue());
            preparedStatement.setInt(6, buildingOrder.getStatus().getId().intValue());
            preparedStatement.setInt(7, buildingOrder.getId().intValue());
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
    public void create(BuildingOrder buildingOrder) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO buildingOrders(building_id, client_id, totalPrice, " +
                            "appartment_id, manager_id, status_id) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, buildingOrder.getBuilding().getId().intValue());
            preparedStatement.setInt(2, buildingOrder.getClient().getId().intValue());
            preparedStatement.setDouble(3, buildingOrder.getTotalPrice());
            preparedStatement.setInt(4, buildingOrder.getApartment().getId().intValue());
            preparedStatement.setInt(5, buildingOrder.getManager().getId().intValue());
            preparedStatement.setInt(6, buildingOrder.getStatus().getId().intValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from buildingOrders where id =?");
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
