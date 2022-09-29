package com.solvd.airport;


import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.mybatis.mysql.AirlineDao;
import com.solvd.airport.models.AirlineModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public static void main(String[] args) {

        disableWarning(); //WARNING


        IAirlineDAO iAirline = new AirlineDao();
        iAirline.createAirline(new AirlineModel("Sky"));
        iAirline.getAirlineById(1);
        iAirline.updateAirline(new AirlineModel(2, "Big Sky"));
        iAirline.deleteAirline(8);


    }

}
