package com.solvd.airport;



import com.solvd.airport.Parser.DOMPar;

import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.IArrivalDAO;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.dao.ITerminalDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.dao.jdbc.mysql.ArrivalDAO;
import com.solvd.airport.dao.jdbc.mysql.LocationDAO;
import com.solvd.airport.dao.jdbc.mysql.TerminalDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.ArrivalModel;
import com.solvd.airport.models.GateModel;
import com.solvd.airport.models.LocationModel;
import com.solvd.airport.services.InfoGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        InfoGeneration.Greetings();

        ////DOM
//        DOMPar.addAirlines(); // airline.xml
//        DOMPar.addLocations(); // location.xml


        ////AIRLINE
        ////CREATE
//        IAirlineDAO iAirline = new AirlineDAO();
//        iAirline.createAirline(new AirlineModel("Sky"));
//
//       ////READ
//        LOGGER.info(iAirline.getAirlineById(1));
//
//        ////UPDATE
//       iAirline.updateAirline(new AirlineModel(6,"Big Sky"));
//
//        ////DELETE
//        iAirline.deleteAirline(8);


        ////LOCATION
        ////CREATE
//        ILocationDAO iLocation = new LocationDAO();
//        iLocation.createLocation(new LocationModel("Spain", "Barcelona"));

        ////READ
//       logger.info(iLocation.getLocationById(2));

        ////UPDATE
//        iLocation.updateLocation(new LocationModel(4, "Antalya"));

        ////DELETE
//        iLocation.deleteLocation(4);


    }

}
