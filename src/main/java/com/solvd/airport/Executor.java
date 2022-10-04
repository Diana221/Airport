package com.solvd.airport;

import com.solvd.airport.services.Admin.AdminService;
import com.solvd.airport.services.User.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {

        AdminService.Greeting();
    }
}
