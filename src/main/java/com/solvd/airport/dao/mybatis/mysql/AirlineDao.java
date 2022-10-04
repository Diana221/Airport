package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.services.User.User;
import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.models.AirlineModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class AirlineDao implements IAirlineDAO {

    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

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
        LOGGER.info("Record inserted successfully! Airline Name: " + airlineModel.getNameAirline());
        session.commit();
        session.close();
    }

    @Override
    public void updateAirline(AirlineModel airlineModel) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.AirlineMapper.updateAirline", airlineModel);
        LOGGER.info("Record updated successfully! New airline name: " + airlineModel.getNameAirline());
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

    @Override
    public void getAll() {
        List<AirlineModel> airlines = new LinkedList<>();
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        airlines = session.selectList("mybatis.mappers.AirlineMapper.getAll", airlines);
        LOGGER.info("Info about airlines: ");
        airlines.forEach(LOGGER::info);
        session.commit();
        session.close();
    }
}
