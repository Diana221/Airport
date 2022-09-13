package com.solvd.airport.dao;

public interface ICrudDAO<T> {

    T  getById(int id);
    void create(T model);
    void update(T model);
    void delete(int id);
}
