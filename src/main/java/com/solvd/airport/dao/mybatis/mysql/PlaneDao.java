package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IPlaneDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.PlaneModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneDao implements IPlaneDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public PlaneModel getById(int id) {
        return null;
    }

    @Override
    public void create(PlaneModel model) {

    }

    @Override
    public void update(PlaneModel model) {

    }

    @Override
    public void delete(int id) {

    }
}
