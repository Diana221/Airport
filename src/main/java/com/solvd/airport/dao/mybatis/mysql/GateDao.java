package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.dao.IGateDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.GateModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class GateDao implements IGateDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public GateModel getById(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        GateModel gateModelRead = session.selectOne("mybatis.mappers.GateMapper.getById", id);
        LOGGER.info("Info about gate: " + gateModelRead);
        session.commit();
        session.close();
        return gateModelRead;
    }

    @Override
    public void create(GateModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.insert("mybatis.mappers.GateMapper.create", model);
        LOGGER.info("Record inserted successfully! Number: " + model.getGateNumber());
        session.commit();
        session.close();
    }

    @Override
    public void update(GateModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.GateMapper.update", model);
        LOGGER.info("Record updated successfully! Number: " + model.getGateNumber());
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.delete("mybatis.mappers.GateMapper.delete", id);
        LOGGER.info("Record deleted successfully! ID: " + id);
        session.commit();
        session.close();
    }

    @Override
    public void getAll() {
        List<GateModel> gates = new LinkedList<>();
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        gates = session.selectList("mybatis.mappers.GateMapper.getAll", gates);
        LOGGER.info("Info about airlines: ");
        gates.forEach(LOGGER::info);
        session.commit();
        session.close();
    }
}
