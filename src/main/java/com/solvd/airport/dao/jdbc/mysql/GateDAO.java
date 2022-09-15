package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IGateDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.GateModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GateDAO implements IGateDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public GateModel getById(int id) {

        GateModel gateModel = new GateModel();
        gateModel.setIdGate(id);

        String SQL_SELECT = "SELECT * FROM gate WHERE idGate = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            gateModel.setGateNumber(resultSet.getInt("gateNumber"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gateModel;
    }

    @Override
    public void create(GateModel model) {

        String SQL_INSERT = "INSERT INTO gate(gateNumber) VALUES (?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getGateNumber());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " gate was added. Number: " + model.getGateNumber());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GateModel model) {

        String SQL_UPDATE = "UPDATE gate SET gateNumber=? WHERE idGate=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getGateNumber());
            preparedStatement.setInt(2, model.getIdGate());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " gate was changed. New number: " + model.getGateNumber());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String SQL_UPDATE = "DELETE FROM gate WHERE idGate=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " gate was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
