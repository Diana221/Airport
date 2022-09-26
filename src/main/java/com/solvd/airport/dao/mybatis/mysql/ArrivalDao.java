package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IArrivalDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.ArrivalModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrivalDao implements IArrivalDAO{

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public ArrivalModel getById(int id) {
        return null;
    }

    @Override
    public void create(ArrivalModel model) {

    }

    @Override
    public void update(ArrivalModel model) {

    }

    @Override
    public void delete(int id) {

    }
}
