package com.solvd.dao.mysql;

import com.solvd.dao.IConstructionMaterialDAO;
import com.solvd.models.ConstructionMaterial;
import com.solvd.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstructionMaterialDAO extends MySQL implements IConstructionMaterialDAO {
    private static final ConstructionMaterialDAO INSTANCE = new ConstructionMaterialDAO();

    private ConstructionMaterialDAO(){}

    public static ConstructionMaterialDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public ConstructionMaterial getByID(Long id) {
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
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return constructionMaterial;
    }

    @Override
    public void update(ConstructionMaterial constructionMaterial) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE constructionMaterials SET material=? where id=?");
            preparedStatement.setString(1, constructionMaterial.getMaterial());
            preparedStatement.setInt(2, constructionMaterial.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public ConstructionMaterial create(ConstructionMaterial constructionMaterial) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO cities(city) VALUES ?");
            preparedStatement.setString(1, constructionMaterial.getMaterial());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return constructionMaterial;
    }

    @Override
    public void remove(Long id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from constructionMaterials where id =?");
            preparedStatement.setInt(1, id.intValue());
            preparedStatement.executeUpdate();
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
