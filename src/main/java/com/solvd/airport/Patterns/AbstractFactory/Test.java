package com.solvd.airport.Patterns.AbstractFactory;

import com.solvd.airport.Patterns.AbstractFactory.Employee.Employee;
import com.solvd.airport.Patterns.AbstractFactory.Employee.EmployeeFactory;
import com.solvd.airport.Patterns.AbstractFactory.Passenger.Passenger;
import com.solvd.airport.Patterns.AbstractFactory.Passenger.PassengerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger LOGGER = LogManager.getLogger(Test.class.getName());

    public static void main(String[] args) {
        EmployeeFactory abstractFactory;
        PassengerFactory abstractFactoryP;

        //EMPLOYEE
        abstractFactory = (EmployeeFactory) FactoryProvider.getFactory("Employee");
        assert abstractFactory != null;
        //Pilot
        Employee pilot = abstractFactory.create("Pilot");
        String employee = pilot.getEmployee();
        //Stewardess
        Employee stewardess = abstractFactory.create("Stewardess");
        employee += ", " + stewardess.getEmployee();

        LOGGER.info("EMPLOYEE:\n" + employee + " was created!");


        //PASSENGER
        abstractFactoryP = (PassengerFactory) FactoryProvider.getFactory("Passenger");
        assert abstractFactoryP != null;
        //Basic
        Passenger basicP = abstractFactoryP.create("Basic");
        String passenger = basicP.getPassenger();
        //Luxury
        Passenger luxeryP = abstractFactoryP.create("Luxury");
        passenger += ", " + luxeryP.getPassenger();

        LOGGER.info("PASSENGER:\n" + passenger + " was created!");

    }
}
