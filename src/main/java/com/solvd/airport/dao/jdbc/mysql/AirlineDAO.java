package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.models.AirlineModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlineDAO implements IAirlineDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    public AirlineModel getAirlineById(int id) {

        AirlineModel airlineModel = new AirlineModel();
        airlineModel.setIdAirline(id);

        String SQL_SELECT = "SELECT * FROM airline WHERE idAirline = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            airlineModel.setNameAirline(resultSet.getString("nameAirline"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlineModel;
    }

    @Override
    public void createAirline(AirlineModel airlineModel) {

        String SQL_INSERT = "INSERT INTO airline(nameAirline) VALUES (?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, airlineModel.getNameAirline());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was added. Name: " + airlineModel.getNameAirline());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAirline(AirlineModel airlineModel) {

        String SQL_UPDATE = "UPDATE airline SET nameAirline=? WHERE idAirline=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, airlineModel.getNameAirline());
            preparedStatement.setInt(2, airlineModel.getIdAirline());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was changed. New name: " + airlineModel.getNameAirline());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAirline(int id) {

        String SQL_UPDATE = "DELETE FROM airline WHERE idAirline=?";
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
