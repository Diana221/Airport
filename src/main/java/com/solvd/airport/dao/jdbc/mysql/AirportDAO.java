package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IAirportDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.AirportModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportDAO implements IAirportDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public AirportModel getById(int id) {

        AirportModel airportModel = new AirportModel();
        airportModel.setIdAirport(id);

        String SQL_SELECT = "SELECT * FROM airport WHERE idAirport = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            airportModel.setAirportName(resultSet.getString("airportName"));
            airportModel.setIdGate(resultSet.getInt("idGate"));
            airportModel.setIdLocation(resultSet.getInt("idLocationAirport"));
            airportModel.setIdTerminal(resultSet.getInt("idTerminal"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airportModel;
    }

    @Override
    public void create(AirportModel model) {
        String SQL_INSERT = "INSERT INTO airport(airportName, idLocationAirport, idGate, idTerminal) VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, model.getAirportName());
            preparedStatement.setInt(2, model.getIdLocation());
            preparedStatement.setInt(3, model.getIdGate());
            preparedStatement.setInt(4, model.getIdTerminal());

            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was added. Name: " + model.getAirportName());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AirportModel model) {
        String SQL_UPDATE = "UPDATE airport SET airportName=? WHERE idAirport=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, model.getAirportName());
            preparedStatement.setInt(2, model.getIdTerminal());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airport was changed. New name: " + model.getAirportName());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String SQL_UPDATE = "DELETE FROM airport WHERE idAirport=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airport was deleted. ID: " + id);
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
