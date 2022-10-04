package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IPlaneDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.PlaneModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneDAO implements IPlaneDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public PlaneModel getById(int id) {
        PlaneModel planeModel = new PlaneModel();
        planeModel.setIdAirline(id);

        String SQL_SELECT = "SELECT * FROM plane WHERE idPlane = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            planeModel.setIdAirline(resultSet.getInt("idAirline"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeModel;
    }

    @Override
    public void create(PlaneModel model) {


        String SQL_INSERT = "INSERT INTO plane VALUES (default, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdAirline());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was added. Name: " + model.getIdAirline());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PlaneModel model) {

        String SQL_UPDATE = "UPDATE plane SET idAirline=? WHERE idPlane=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdAirline());
            preparedStatement.setInt(2, model.getIdPlane());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was changed. New id: " + model.getIdAirline());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM plane WHERE idPlane=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " plane was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAll() {

    }
}
