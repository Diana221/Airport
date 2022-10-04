package com.solvd.airport.dao.jdbc.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IMissingBaggagesDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.MissingBaggagesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissingBaggagesDAO implements IMissingBaggagesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());

    @Override
    public MissingBaggagesModel getById(int id) {

        MissingBaggagesModel missingBaggagesModel = new MissingBaggagesModel();
        missingBaggagesModel.setIdMissingBaggage(id);

        String SQL_SELECT = "SELECT * FROM missing_baggages WHERE idMissingBaggages = " + id;
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            missingBaggagesModel.setIdBaggage(resultSet.getInt("idBaggage"));
            missingBaggagesModel.setDescriptionB(resultSet.getString("descriptionB"));
            missingBaggagesModel.setStatusB(resultSet.getString("statusB"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missingBaggagesModel;
    }

    @Override
    public void create(MissingBaggagesModel model) {

        String SQL_INSERT = "INSERT INTO missing_baggages VALUES (?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
            preparedStatement.setInt(1, model.getIdBaggage());
            preparedStatement.setString(2, model.getStatusB());
            preparedStatement.setString(3, model.getDescriptionB());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " missing baggage was added. id: " + model.getIdMissingBaggage());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MissingBaggagesModel model) {

        String SQL_UPDATE = "UPDATE missing_baggages SET idBaggage=? WHERE idMissingBaggages=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, model.getIdBaggage());
            preparedStatement.setInt(2, model.getIdMissingBaggage());
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " missing baggage was changed. New id: " + model.getIdMissingBaggage());
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL_UPDATE = "DELETE FROM missing_baggages WHERE idMissingBaggages=?";
        try (Connection conn = SQLConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            LOGGER.info(row + " missing baggage was deleted. ID: " + id);
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
