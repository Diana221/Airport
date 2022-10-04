package com.solvd.airport.services.User;


import com.solvd.airport.dao.IPassengersDAO;
import com.solvd.airport.dao.jdbc.mysql.PassengersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class User {

    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void main(String[] args) throws IOException {
        UserService.User();

    }
}
