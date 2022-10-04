package com.solvd.airport.Patterns.AbstractFactory.Passenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LuxPassenger extends Passenger{
    private static final Logger LOGGER = LogManager.getLogger(LuxPassenger.class.getName());

    boolean status = true;
    public String getPassenger() {
        return "Luxury passenger";
    }
}
