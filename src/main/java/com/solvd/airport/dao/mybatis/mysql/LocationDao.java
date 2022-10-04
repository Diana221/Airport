package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.GateModel;
import com.solvd.airport.models.LocationModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LocationDao implements ILocationDAO {


    private static final Logger LOGGER = LogManager.getLogger(LocationDao.class.getName());


    @Override
    public LocationModel getLocationById(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        LocationModel locationModelRead = session.selectOne("mybatis.mappers.LocationMapper.getLocationById", id);
        LOGGER.info("Info about location: " + locationModelRead);
        session.commit();
        session.close();
        return locationModelRead;
    }

    @Override
    public void createLocation(LocationModel locationModel) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.insert("mybatis.mappers.LocationMapper.createLocation", locationModel);
        LOGGER.info("Record inserted successfully! Country: " + locationModel.getCountry());
        session.commit();
        session.close();
    }

    @Override
    public void updateLocation(LocationModel locationModel) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.LocationMapper.updateLocation", locationModel);
        LOGGER.info("Record updated successfully! Country: " + locationModel.getCountry());
        session.commit();
        session.close();
    }

    @Override
    public void deleteLocation(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.delete("mybatis.mappers.LocationMapper.deleteLocation", id);
        LOGGER.info("Record deleted successfully! ID: " + id);
        session.commit();
        session.close();
    }

    @Override
    public void getAllLocation() {
        List<LocationModel> locations = new LinkedList<>();
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        locations = session.selectList("mybatis.mappers.LocationMapper.getAll", locations);
        LOGGER.info("Info about locations: ");
        locations.forEach(LOGGER::info);
        session.commit();
        session.close();
    }
}
