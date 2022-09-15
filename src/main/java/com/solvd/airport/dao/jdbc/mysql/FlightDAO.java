package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IFlightDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.FlightModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDAO implements IFlightDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public FlightModel getById(int id) {

        FlightModel flightModel = new FlightModel();
        flightModel.setIdFlight(id);

        String SQL_SELECT = "SELECT * FROM flight WHERE idFlight = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            flightModel.setIdAirlineF(resultSet.getInt("idAirlineF"));
            flightModel.setIdSchedule(resultSet.getInt("idSchedule"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightModel;
    }

    @Override
    public void create(FlightModel model) {

        String SQL_INSERT = "INSERT INTO flight VALUES (default, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdAirlineF());
            preparedStatement.setInt(2, model.getIdSchedule());

            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " flight was added. ID: " + model.getIdFlight());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FlightModel model) {

        String SQL_UPDATE = "UPDATE flight SET idAirlineF=? WHERE idFlight=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdAirlineF());
            preparedStatement.setInt(2, model.getIdFlight());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " idAirline was changed. New ID: " + model.getIdAirlineF());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM flight WHERE idFlight=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
