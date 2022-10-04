package com.solvd.airport.dao.jdbc.mysql;


import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ITicketDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO implements ITicketDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public TicketModel getById(int id) {

        TicketModel ticketModel = new TicketModel();
        ticketModel.setIdTicket(id);

        String SQL_SELECT = "SELECT * FROM ticket WHERE idTicket = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ticketModel.setIdPassengerT(resultSet.getInt("idPassengerT"));
            ticketModel.setPrice(resultSet.getInt("price"));
            ticketModel.setSeat(resultSet.getString("seat"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketModel;
    }

    @Override
    public void create(TicketModel model) {

        String SQL_INSERT = "INSERT INTO ticket VALUES (default, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdPassengerT());
            preparedStatement.setString(2, model.getSeat());
            preparedStatement.setInt(3, model.getPrice());

            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " ticket was added. ID: " + model.getIdTicket());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TicketModel model) {

        String SQL_UPDATE = "UPDATE ticket SET price=? WHERE idTicket=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getPrice());
            preparedStatement.setInt(2, model.getIdTicket());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " ticket was changed. New price: " + model.getPrice());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM ticket WHERE idPlane=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " ticket was deleted. ID: " + id);
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
