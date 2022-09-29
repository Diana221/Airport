package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.Main;
import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.models.AirlineModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirlineDao implements IAirlineDAO {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    @Override
    public void getAirlineById(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        AirlineModel airlineModelRead = session.selectOne("mybatis.mappers.AirlineMapper.getAirlineById", id);
        LOGGER.info("Info about airline: " + airlineModelRead.toString());
        session.commit();
        session.close();
    }

    @Override
    public void createAirline(AirlineModel airlineModel) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.insert("mybatis.mappers.AirlineMapper.createAirline", airlineModel);
        LOGGER.info("Record inserted successfully! Name: " + airlineModel.getNameAirline());
        session.commit();
        session.close();
    }

    @Override
    public void updateAirline(AirlineModel airlineModel) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.AirlineMapper.updateAirline", airlineModel);
        LOGGER.info("Record updated successfully! New name: " + airlineModel.getNameAirline());
        session.commit();
        session.close();
    }

    @Override
    public void deleteAirline(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.delete("mybatis.mappers.AirlineMapper.deleteAirline", id);
        LOGGER.info("Record deleted successfully! ID: " + id);
        session.commit();
        session.close();
    }
}
