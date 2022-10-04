package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IPassengersDAO;
import com.solvd.airport.models.PassengersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengersDAO implements IPassengersDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public PassengersModel getById(int id) {

        PassengersModel passengersModel = new PassengersModel();
        passengersModel.setIdPassenger(id);

        String SQL_SELECT = "SELECT * FROM passengers WHERE idPassenger = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            passengersModel.setPname(resultSet.getString("Pname"));
            passengersModel.setSurname(resultSet.getString("surname"));
            passengersModel.setEmail(resultSet.getString("email"));
            passengersModel.setPhoneNumber(resultSet.getString("phoneNumber"));
            passengersModel.setIdFlight(resultSet.getInt("idFlight"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passengersModel;
    }

    public void getByName(String name, String surname) {

        PassengersModel passengersModel = new PassengersModel();
        passengersModel.setPname(name);

        String SQL_SELECT = "SELECT * FROM passengers WHERE Pname = " + name ;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            passengersModel.setIdPassenger(resultSet.getInt("idPassenger"));
            passengersModel.setSurname(resultSet.getString("surname"));
            passengersModel.setEmail(resultSet.getString("email"));
            passengersModel.setPhoneNumber(resultSet.getString("phoneNumber"));
            passengersModel.setIdFlight(resultSet.getInt("idFlight"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(PassengersModel model) {

        String SQL_INSERT = "INSERT INTO passengers(Pname, surname, phoneNumber, email, idFlight) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, model.getPname());
            preparedStatement.setString(2, model.getSurname());
            preparedStatement.setString(3, model.getPhoneNumber());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setInt(5, model.getIdFlight());

            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " passenger was added. Name: " + model.getPname());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(PassengersModel model) {

        String SQL_UPDATE = "UPDATE passengers SET Pname=? WHERE idPassenger=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, model.getPname());
            preparedStatement.setInt(2, model.getIdPassenger());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " passenger was changed. New name: " + model.getPname());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM passengers WHERE idPassenger=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " passenger was deleted. ID: " + id);
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
