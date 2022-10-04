package com.solvd.airport.Patterns.AbstractFactory.Employee;

import com.solvd.airport.Patterns.AbstractFactory.AbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeFactory implements AbstractFactory<Employee> {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeFactory.class.getName());

    public  Employee create(String EmployeeType) {
        if ("Pilot".equalsIgnoreCase(EmployeeType)) {
            return new Pilot();

        } else if ("Stewardess".equalsIgnoreCase(EmployeeType)) {
            return new Stewardess();
        }
        else
        {
            LOGGER.info("Please, Enter pilot or stewardess");
        }

        return null;
    }
}
