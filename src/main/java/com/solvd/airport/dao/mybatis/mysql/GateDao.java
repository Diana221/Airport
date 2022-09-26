package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IGateDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.GateModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GateDao implements IGateDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public GateModel getById(int id) {
        return null;
    }

    @Override
    public void create(GateModel model) {

    }

    @Override
    public void update(GateModel model) {

    }

    @Override
    public void delete(int id) {

    }
}
