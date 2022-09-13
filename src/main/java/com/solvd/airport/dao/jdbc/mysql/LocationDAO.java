package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;


import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.models.LocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO implements ILocationDAO {


    private static final Logger logger = LogManager.getLogger(LocationDAO.class.getName());


    public LocationModel getLocationById(int id) {

        LocationModel locationModel = new LocationModel();
        locationModel.setIdLocation(id);

        String SQL_SELECT = "SELECT * FROM location WHERE idLocation = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            locationModel.setCountry(resultSet.getString("country"));
            locationModel.setCity(resultSet.getString("city"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locationModel;
    }

    @Override
    public void createLocation(LocationModel locationModel) {

        String SQL_INSERT = "INSERT INTO location(country, city) VALUES (?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, locationModel.getCountry());
            preparedStatement.setString(2, locationModel.getCity());
            int row = preparedStatement.executeUpdate();
            logger.info(row + " location was added. Country: " +
                    locationModel.getCountry() + "(" + locationModel.getCity() + ")");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLocation(LocationModel locationModel) {

        String SQL_UPDATE = "UPDATE location SET city=? WHERE idLocation=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, locationModel.getCity());
            preparedStatement.setInt(2, locationModel.getIdLocation());
            int row = preparedStatement.executeUpdate();
            logger.info(row + " location was changed. New city: " + locationModel.getCity());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLocation(int id) {

        String SQL_UPDATE = "DELETE FROM location WHERE idLocation=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            logger.info(row + " location was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
