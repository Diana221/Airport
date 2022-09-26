package com.solvd.airport;

import com.solvd.airport.services.InfoGeneration;

import java.io.IOException;

public class Executor {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {


          InfoGeneration.User();

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
