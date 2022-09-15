package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ITerminalDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.TerminalModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TerminalDAO implements ITerminalDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public TerminalModel getById(int id) {
        TerminalModel terminalModel = new TerminalModel();
        terminalModel.setIdTerminal(id);

        String SQL_SELECT = "SELECT * FROM terminal WHERE idTerminal = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            terminalModel.setTerminalName(resultSet.getString("terminalName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terminalModel;
    }

    @Override
    public void create(TerminalModel model) {
        String SQL_INSERT = "INSERT INTO terminal(terminalName) VALUES (?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, model.getTerminalName());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " terminal was added. Name: " + model.getTerminalName());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TerminalModel model) {

        String SQL_UPDATE = "UPDATE terminal SET terminalName=? WHERE idTerminal=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, model.getTerminalName());
            preparedStatement.setInt(2, model.getIdTerminal());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " terminal was changed. New name: " + model.getTerminalName());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String SQL_UPDATE = "DELETE FROM terminal WHERE idTerminal=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " terminal was deleted. ID: " + id);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
