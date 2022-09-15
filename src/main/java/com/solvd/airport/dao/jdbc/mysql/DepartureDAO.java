package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IDepartureDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.DepartureModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartureDAO implements IDepartureDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public DepartureModel getById(int id) {

        DepartureModel departureModel = new DepartureModel();
        departureModel.setIdDeparture(id);

        String SQL_SELECT = "SELECT * FROM departure WHERE idDeparture = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            departureModel.setIdAirport(resultSet.getInt("idAirport"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departureModel;
    }

    @Override
    public void create(DepartureModel model) {

        String SQL_INSERT = "INSERT INTO departure(idAirport) VALUES (?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdAirport());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " departure was added. Airport ID: " + model.getIdAirport());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DepartureModel model) {

        String SQL_UPDATE = "UPDATE departure SET idAirport=? WHERE idDeparture=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdAirport());
            preparedStatement.setInt(2, model.getIdDeparture());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was changed. New airport ID: " + model.getIdAirport());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM departure WHERE idDeparture=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " departure was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
