package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IMissingBaggagesDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.MissingBaggagesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissingBaggagesDao implements IMissingBaggagesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public MissingBaggagesModel getById(int id) {
        return null;
    }

    @Override
    public void create(MissingBaggagesModel model) {

    }

    @Override
    public void update(MissingBaggagesModel model) {

    }

    @Override
    public void delete(int id) {

    }
}
