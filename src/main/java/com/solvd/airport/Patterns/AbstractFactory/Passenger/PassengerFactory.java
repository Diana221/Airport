package com.solvd.airport.Patterns.AbstractFactory.Passenger;

import com.solvd.airport.Patterns.AbstractFactory.AbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PassengerFactory implements AbstractFactory<Passenger> {
    private static final Logger LOGGER = LogManager.getLogger(PassengerFactory.class.getName());

    public  Passenger create(String PassengerType) {
        if ("Basic".equalsIgnoreCase(PassengerType)) {
            return new Passenger();

        } else if ("Luxury".equalsIgnoreCase(PassengerType)) {
            return new LuxPassenger();
        }
        else
        {
            LOGGER.info("Please, Enter basic or luxury");
        }

        return null;
    }
}
