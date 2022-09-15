package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IScheduleFlightDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.ScheduleFlightModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleFlightDAO implements IScheduleFlightDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public ScheduleFlightModel getById(int id) {

        ScheduleFlightModel scheduleFlightModel = new ScheduleFlightModel();
        scheduleFlightModel.setIdSchedule(id);

        String SQL_SELECT = "SELECT * FROM schedule_flight WHERE idSchedule = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            scheduleFlightModel.setDuration(resultSet.getInt("duration"));
            scheduleFlightModel.setDuration(resultSet.getInt("idDeparture"));
            scheduleFlightModel.setDuration(resultSet.getInt("idArrival"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleFlightModel;
    }

    @Override
    public void create(ScheduleFlightModel model) {

        String SQL_INSERT = "INSERT INTO schedule_flight VALUES (default, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setDouble(1, model.getDuration());
            preparedStatement.setInt(1, model.getIdArrival());
            preparedStatement.setInt(1, model.getIdDeparture());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " schedule was added.");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ScheduleFlightModel model) {

        String SQL_UPDATE = "UPDATE schedule_flight SET duration=? WHERE idSchedule=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setDouble(1, model.getDuration());
            preparedStatement.setInt(2, model.getIdSchedule());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " airline was changed. New duration: " + model.getDuration());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM schedule_flight WHERE idSchedule=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " schedule was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
