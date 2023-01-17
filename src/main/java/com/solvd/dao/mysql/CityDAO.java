package com.solvd.dao.mysql;

import com.solvd.dao.ICityDAO;
import com.solvd.exceptions.ConnectionPoolException;
import com.solvd.exceptions.DAOException;
import com.solvd.models.City;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO extends MySQL implements ICityDAO {
    private static final CityDAO INSTANCE = new CityDAO();

    private static final Logger LOGGER = Logger.getLogger(CityDAO.class);

    private CityDAO(){}

    public static CityDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public City getByID(Long id) throws DAOException {
        City city = new City();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from cities where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city = new City((long) resultSet.getInt("id"),
                        resultSet.getString("city"));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return city;
    }

    @Override
    public void update(City city) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE cities SET city=? where id=?");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setInt(2, city.getId().intValue());
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
    public City create(City city) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cities(city) VALUES ?");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return city;
    }

    @Override
    public void remove(Long id) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from cities where id =?");
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
