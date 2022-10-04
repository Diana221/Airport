package com.solvd.airport.Patterns.Strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger LOGGER = LogManager.getLogger(com.solvd.airport.Patterns.AbstractFactory.Test.class.getName());

    public static void main(String[] args) {

        Context context = new Context(new IncreaseSalary());
        LOGGER.info("Increased salary: " + context.executeStrategy(200));
        context = new Context(new DecreaseSalary());
        LOGGER.info("Decreased salary: " + context.executeStrategy(400));
    }

    }
