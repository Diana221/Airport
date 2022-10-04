package com.solvd.airport.Patterns.Strategy;

public class Context {

    private final Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int salary){
        return strategy.doOperation(salary);
    }
}
