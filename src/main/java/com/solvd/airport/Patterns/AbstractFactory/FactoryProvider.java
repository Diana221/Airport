package com.solvd.airport.Patterns.AbstractFactory;

import com.solvd.airport.Patterns.AbstractFactory.Employee.EmployeeFactory;
import com.solvd.airport.Patterns.AbstractFactory.Passenger.PassengerFactory;

public class FactoryProvider {

    public static AbstractFactory getFactory(String choice){

        if("Employee".equalsIgnoreCase(choice)){
            return new EmployeeFactory();
        }
        else if("Passenger".equalsIgnoreCase(choice)){
            return new PassengerFactory();
        }

        return null;
    }
}
