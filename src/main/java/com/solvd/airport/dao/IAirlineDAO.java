package com.solvd.airport.dao;

import com.solvd.airport.models.AirlineModel;

public interface IAirlineDAO {

    void getAirlineById(int id);
    void createAirline(AirlineModel airlineModel);
    void updateAirline(AirlineModel airlineModel);
    void deleteAirline(int id);
    void getAll();

}
