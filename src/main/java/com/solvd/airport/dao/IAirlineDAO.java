package com.solvd.airport.dao;

import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.LocationModel;

import java.util.List;

public interface IAirlineDAO {

    AirlineModel getAirlineById(int id);
    void createAirline(AirlineModel airlineModel);
    void updateAirline(AirlineModel airlineModel);
    void deleteAirline(int id);

}
