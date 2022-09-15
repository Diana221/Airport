package com.solvd.airport.dao;

public interface IBaseDAO<T> {

    T  getById(int id);
    void create(T model);
    void update(T model);
    void delete(int id);
}
