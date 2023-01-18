package com.solvd.dao.mysql;

import com.solvd.dao.IApartmentDAO;
import com.solvd.exceptions.ConnectionPoolException;
import com.solvd.exceptions.DAOException;
import com.solvd.models.Apartment;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartmentDAO extends MySQL implements IApartmentDAO {
    private static final ApartmentDAO INSTANCE = new ApartmentDAO();

    private static final Logger LOGGER = Logger.getLogger(ApartmentDAO.class);

    private ApartmentDAO(){}

    public static ApartmentDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Apartment getByID(Long id) throws DAOException {
        Apartment apartment = new Apartment();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from appartments where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                apartment = new Apartment((long) resultSet.getInt("id"), resultSet
                        .getInt("rooms"), resultSet.getInt("floor"),
                        resultSet.getDouble("area"),
                        BuildingDAO.getInstance().getByID(apartment.getBuilding().getId()));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return apartment;
    }

    @Override
    public void update(Apartment apartment) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE appartments SET rooms=?, floor=?, area=?, building_id=? where id=?");
            preparedStatement.setInt(1, apartment.getRooms());
            preparedStatement.setInt(2, apartment.getFloor());
            preparedStatement.setDouble(3, apartment.getArea());
            preparedStatement.setInt(4, apartment.getBuilding().getId().intValue());
            preparedStatement.setInt(5, apartment.getId().intValue());
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
    public Apartment create(Apartment apartment) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO appartments(rooms, floor, area, building_id) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, apartment.getRooms());
            preparedStatement.setInt(2, apartment.getFloor());
            preparedStatement.setDouble(3, apartment.getArea());
            preparedStatement.setInt(4, apartment.getBuilding().getId().intValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return apartment;
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from appartments where id =?");
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
