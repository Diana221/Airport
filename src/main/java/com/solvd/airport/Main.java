package com.solvd.airport;


import com.solvd.airport.Parser.DOMPar;
import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.dao.jdbc.mysql.LocationDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.LocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

                                                  ////AIRLINE
        ////CREATE
//        IAirlineDAO iAirlineCreate = new AirlineDAO();
//        iAirlineCreate.createAirline(new AirlineModel("Sky"));


       ////READ
//        IAirlineDAO iAirlineGet = new AirlineDAO();
//       logger.info(iAirlineGet.getAirlineById(1));


        ////UPDATE
//        IAirlineDAO iAirlineUpdate = new AirlineDAO();
//        iAirlineUpdate.updateAirline(new AirlineModel(6,"Big Sky"));
//

        ////DELETE
//        IAirlineDAO iAirlineDelete = new AirlineDAO();
//        iAirlineDelete.deleteAirline(8);





                                                    ////LOCATION
        ////CREATE
//        ILocationDAO iLocationCreate = new LocationDAO();
//        iLocationCreate.createLocation(new LocationModel("Spain", "Barcelona"));


        ////READ
//        ILocationDAO iLocationGet = new LocationDAO();
//       logger.info(iLocationGet.getLocationById(2));


       ////UPDATE
//        ILocationDAO iLocationUpdate = new LocationDAO();
//        iLocationUpdate.updateLocation(new LocationModel(4, "Antalya"));


        ////DELETE
//        ILocationDAO iLocationDelete = new LocationDAO();
//        iLocationDelete.deleteLocation(4);




        //// XML DOM PARSER
//        DOMPar.addAirlines(); // airline.xml
//        DOMPar.addLocations(); // location.xml

    }
}
