package com.solvd.dao.mysql;

import com.solvd.dao.IConstructionMaterialDAO;
import com.solvd.utils.exceptions.ConnectionPoolException;
import com.solvd.utils.exceptions.DAOException;
import com.solvd.models.ConstructionMaterial;
import com.solvd.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstructionMaterialDAO extends MySQL implements IConstructionMaterialDAO {
    private static final ConstructionMaterialDAO INSTANCE = new ConstructionMaterialDAO();

    private static final Logger LOGGER = Logger.getLogger(ConstructionMaterialDAO.class);

    private ConstructionMaterialDAO(){}

    public static ConstructionMaterialDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public ConstructionMaterial getByID(Long id) throws DAOException {
        ConstructionMaterial constructionMaterial = new ConstructionMaterial();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from constructionMaterials where id = ?");
            preparedStatement.setInt(1, id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                constructionMaterial = new ConstructionMaterial((long) resultSet.getInt("id"),
                        resultSet.getString("material"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return constructionMaterial;
    }

    @Override
    public void update(ConstructionMaterial constructionMaterial) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE constructionMaterials SET material=? where id=?");
            preparedStatement.setString(1, constructionMaterial.getMaterial());
            preparedStatement.setInt(2, constructionMaterial.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void create(ConstructionMaterial constructionMaterial) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO constructionMaterials(material) VALUES ?");
            preparedStatement.setString(1, constructionMaterial.getMaterial());
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
                    .prepareStatement("DELETE from constructionMaterials where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error(e);
            throw new DAOException();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
