package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IPilotsDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.PilotsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PilotsDAO implements IPilotsDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public PilotsModel getById(int id) {

        PilotsModel pilotsModel = new PilotsModel();
        pilotsModel.setIdPilot(id);

        String SQL_SELECT = "SELECT * FROM airline WHERE idAirline = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            pilotsModel.setPname(resultSet.getString("Pname"));
            pilotsModel.setIdPlane(resultSet.getInt("idPlane"));
            pilotsModel.setSalary(resultSet.getInt("salary"));
            pilotsModel.setSurname(resultSet.getString("surname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pilotsModel;
    }

    @Override
    public void create(PilotsModel model) {

        String SQL_INSERT = "INSERT INTO pilots VALUES (default, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, model.getPname());
            preparedStatement.setString(2, model.getSurname());
            preparedStatement.setInt(3, model.getIdPlane());
            preparedStatement.setInt(4, model.getSalary());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " pilot was added. Name: " + model.getPname());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PilotsModel model) {

        String SQL_UPDATE = "UPDATE pilots SET Pname=? WHERE idPilot=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, model.getPname());
            preparedStatement.setInt(2, model.getIdPilot());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " pilot was changed. New name: " + model.getPname());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM pilots WHERE idPilots=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " pilot was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
