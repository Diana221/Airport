package com.solvd.airport;


import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.models.AirlineModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {


        //CREATE
//        IAirlineDAO iAirlineCreate = new AirlineDAO();
//        iAirlineCreate.createAirline(new AirlineModel("Sky"));


        //READ
//        IAirlineDAO iAirlineGet = new AirlineDAO();
//       logger.info(iAirlineGet.getAirlineById(1));


        //UPDATE
//        IAirlineDAO iAirlineUpdate = new AirlineDAO();
//        iAirlineUpdate.updateAirline(new AirlineModel(6,"Big Sky"));
//

        //DELETE
//        IAirlineDAO iAirlineDelete = new AirlineDAO();
//        iAirlineDelete.deleteAirline(8);

    }
}
