package com.solvd.dao.mysql;

import com.solvd.dao.IBuildingTypeDAO;
import com.solvd.utils.exceptions.ConnectionPoolException;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.models.BuildingType;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingTypeDAO extends MySQL implements IBuildingTypeDAO {
    private static final BuildingTypeDAO INSTANCE = new BuildingTypeDAO();

    private static final Logger LOGGER = Logger.getLogger(BuildingTypeDAO.class);

    private BuildingTypeDAO(){}

    public static BuildingTypeDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public BuildingType getByID(Long id) throws DAOException {
        BuildingType buildingType = new BuildingType();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from types where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buildingType = new BuildingType((long) resultSet.getInt("id"),
                        resultSet.getString("type"));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return buildingType;
    }

    @Override
    public void update(BuildingType buildingType) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE types SET type=? where id=?");
            preparedStatement.setString(1, buildingType.getTypeName());
            preparedStatement.setInt(2, buildingType.getId().intValue());
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
    public void create(BuildingType buildingType) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO types(type) VALUES ?");
            preparedStatement.setString(1, buildingType.getTypeName());
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
                    .prepareStatement("DELETE from types where id =?");
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
