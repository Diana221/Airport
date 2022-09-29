package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.MyBatisConnection;
import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ITerminalDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.PlaneModel;
import com.solvd.airport.models.TerminalModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TerminalDao implements ITerminalDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirlineDAO.class.getName());


    @Override
    public TerminalModel getById(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        TerminalModel terminalModelRead = session.selectOne("mybatis.mappers.TerminalMapper.getById", id);
        LOGGER.info("Info about plane: " );
        session.commit();
        session.close();
        return terminalModelRead;
    }

    @Override
    public void create(TerminalModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.insert("mybatis.mappers.TerminalMapper.createTerminal", model);
        LOGGER.info("Record inserted successfully! Name: " + model.getTerminalName());
        session.commit();
        session.close();
    }

    @Override
    public void update(TerminalModel model) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.update("mybatis.mappers.TerminalMapper.updateTerminal", model);
        LOGGER.info("Record updated successfully! Name: " + model.getTerminalName());
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession();
        session.delete("mybatis.mappers.TerminalMapper.deleteTerminal", id);
        LOGGER.info("Record deleted successfully! ID: " + id);
        session.commit();
        session.close();
    }
}
