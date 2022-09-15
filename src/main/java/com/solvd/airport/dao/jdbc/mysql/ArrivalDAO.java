package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IArrivalDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.ArrivalModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrivalDAO implements IArrivalDAO{

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public ArrivalModel getById(int id) {

        ArrivalModel arrivalModel = new ArrivalModel();
        arrivalModel.setIdArrival(id);

        String SQL_SELECT = "SELECT * FROM arrival WHERE idArrival = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            arrivalModel.setIdAirportA(resultSet.getInt("idAirportA"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrivalModel;
    }

    @Override
    public void create(ArrivalModel model) {

        String SQL_INSERT = "INSERT INTO arrival VALUES (default, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdAirportA());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " arrival was added. Airport ID: " + model.getIdAirportA());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ArrivalModel model) {

        String SQL_UPDATE = "UPDATE arrival SET idAirportA=? WHERE idArrival=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdAirportA());
            preparedStatement.setInt(2, model.getIdArrival());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " arrival was changed. New airport ID: " + model.getIdAirportA());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM arrival WHERE idArrival=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " arrival was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
