package com.solvd.airport.services.User;

import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.dao.IPassengersDAO;
import com.solvd.airport.dao.jdbc.mysql.LocationDAO;
import com.solvd.airport.dao.jdbc.mysql.PassengersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShowTables {
    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void ShowLocation(){
        ILocationDAO iLocation = new LocationDAO();
        iLocation.getAllLocation();
    }

    public static void ShowPassenger(int id){
        IPassengersDAO iPassenger = new PassengersDAO();
        LOGGER.info(iPassenger.getById(id).getIdPassenger());
    }
}
