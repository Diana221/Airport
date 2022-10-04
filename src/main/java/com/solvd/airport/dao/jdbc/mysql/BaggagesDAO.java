package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IBaggagesDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.BaggagesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaggagesDAO implements IBaggagesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public BaggagesModel getById(int id) {
        BaggagesModel baggagesModel = new BaggagesModel();
        baggagesModel.setIdBaggage(id);

        String SQL_SELECT = "SELECT * FROM baggages WHERE idBaggage= " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            baggagesModel.setIdPassenger(resultSet.getInt("idPassenger"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baggagesModel;
    }

    @Override
    public void create(BaggagesModel model) {

        String SQL_INSERT = "INSERT INTO baggages VALUES (default, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdPassenger());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " baggage was added. id: " + model.getIdPassenger());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BaggagesModel model) {

        String SQL_UPDATE = "UPDATE baggages SET idPassenger=? WHERE idBaggage=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdPassenger());
            preparedStatement.setInt(2, model.getIdBaggage());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " baggage was changed. New id: " + model.getIdBaggage());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM baggage WHERE idBaggage=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " baggage was deleted. ID: " + id);
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
