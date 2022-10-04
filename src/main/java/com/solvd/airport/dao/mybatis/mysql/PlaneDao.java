package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.IPlaneDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.GateModel;
import com.solvd.airport.models.PlaneModel;
import org.apache.ibatis.session.SqlSession;
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
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        PlaneModel planeModelRead = session.selectOne("mybatis.mappers.PlaneMapper.getById", id);
        LOGGER.info("Info about plane: " + planeModelRead);
        session.commit();
        session.close();
        return planeModelRead;
    }

    @Override
    public void create(PlaneModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.insert("mybatis.mappers.PlaneMapper.create", model);
        LOGGER.info("Record inserted successfully! ID Airline: " + model.getIdAirline());
        session.commit();
        session.close();
    }

    @Override
    public void update(PlaneModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.PlaneMapper.update", model);
        LOGGER.info("Record updated successfully! ID Airline: " + model.getIdAirline());
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.delete("mybatis.mappers.PlaneMapper.delete", id);
        LOGGER.info("Record deleted successfully! ID: " + id);
        session.commit();
        session.close();
    }

    @Override
    public void getAll() {

    }
}
