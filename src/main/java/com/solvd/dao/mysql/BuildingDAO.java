package com.solvd.dao.mysql;

import com.solvd.dao.IBuildingDAO;
import com.solvd.utils.exceptions.ConnectionPoolException;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.models.*;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingDAO extends MySQL implements IBuildingDAO {
    private static final BuildingDAO INSTANCE = new BuildingDAO();

    private static final Logger LOGGER = Logger.getLogger(BuildingDAO.class);

    private BuildingDAO(){}

    public static BuildingDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Building getByID(Long id) throws DAOException {
        Building building = new Building();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from buildings where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                building = new Building(resultSet.getString("name"), BuildingTypeDAO.getInstance()
                        .getByID((long) resultSet.getInt("type_id")), resultSet.
                        getDouble("area"), resultSet.getInt("floors"),
                        ConstructionMaterialDAO.getInstance().getByID((long) resultSet.
                                getInt("constructionMaterial_id")), CityDAO.getInstance().
                        getByID((long) resultSet.getInt("city_id")), resultSet.
                        getString("adress"));
            }
            preparedStatement.close();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return building;
    }

    @Override
    public void update(Building building) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE buildings SET name=?, type_id=?, area=?, floors=?," +
                            "constructionMaterial_id=?, city_id=?,adress=? where id=?");
            preparedStatement.setString(1, building.getBuildingName());
            preparedStatement.setInt(2, building.getType().getId().intValue());
            preparedStatement.setDouble(3, building.getArea());
            preparedStatement.setInt(4, building.getFloors());
            preparedStatement.setInt(5, building.getMaterial().getId().intValue());
            preparedStatement.setInt(6, building.getCity().getId().intValue());
            preparedStatement.setString(7, building.getAddress());
            preparedStatement.setInt(8, building.getId().intValue());
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
    public void create(Building building) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO buildings(name, type_id, area,floors,constructionMaterial_id," +
                            "city_id, adress) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, building.getBuildingName());
            preparedStatement.setInt(2, building.getType().getId().intValue());
            preparedStatement.setDouble(3, building.getArea());
            preparedStatement.setInt(4, building.getFloors());
            preparedStatement.setInt(5, building.getMaterial().getId().intValue());
            preparedStatement.setInt(6, building.getCity().getId().intValue());
            preparedStatement.setString(7, building.getAddress());
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
                    .prepareStatement("DELETE from buildings where id=?");
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
