package com.solvd.airport.Patterns.Strategy;

public class IncreaseSalary implements Strategy{
    @Override
    public int doOperation(int salary) {
        return salary + salary/2;
    }
}
