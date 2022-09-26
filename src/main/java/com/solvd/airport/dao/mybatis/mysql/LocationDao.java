package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.models.LocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDao implements ILocationDAO {


    private static final Logger LOGGER = LogManager.getLogger(LocationDao.class.getName());


    @Override
    public LocationModel getLocationById(int id) {
        return null;
    }

    @Override
    public void createLocation(LocationModel locationModel) {

    }

    @Override
    public void updateLocation(LocationModel locationModel) {

    }

    @Override
    public void deleteLocation(int id) {

    }
}
