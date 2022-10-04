package com.solvd.airport.Patterns.AbstractFactory.Passenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Passenger {
    private static final Logger LOGGER = LogManager.getLogger(Passenger.class.getName());

    public String getPassenger() {
        return "Basic passenger";
    }

}
