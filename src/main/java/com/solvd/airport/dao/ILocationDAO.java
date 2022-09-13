package com.solvd.airport.dao;


import com.solvd.airport.models.LocationModel;

public interface ILocationDAO {

    LocationModel getLocationById(int id);
    void createLocation(LocationModel locationModel);
    void updateLocation(LocationModel locationModel);
    void deleteLocation(int id);


}
