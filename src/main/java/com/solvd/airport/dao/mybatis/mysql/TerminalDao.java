package com.solvd.airport.dao.mybatis.mysql;

import com.solvd.airport.configuration.SQLConnection;
import com.solvd.airport.dao.ITerminalDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.TerminalModel;
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
        return null;
    }

    @Override
    public void create(TerminalModel model) {

    }

    @Override
    public void update(TerminalModel model) {

    }

    @Override
    public void delete(int id) {

    }
}
