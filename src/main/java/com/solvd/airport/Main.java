package com.solvd.airport;


import com.solvd.airport.models.AirlineModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Reader;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public static void main(String[] args) {

        disableWarning(); //WARNING

        try {
            Reader reader = Resources.getResourceAsReader("mybatis/MyBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();


            //AIRLINE
            //CREATE
            AirlineModel airlineModelCreate = new AirlineModel("dianasky");
            session.insert("mybatis.AirlineMapper.createAirline", airlineModelCreate);
            LOGGER.info("Record inserted successfully");


            //READ
            AirlineModel airlineModelRead = (AirlineModel) session.selectOne("mybatis.AirlineMapper.getAirlineById", 3);
            LOGGER.info("Info about airline:");
            LOGGER.info(airlineModelRead.toString());


            //UPDATE
            AirlineModel airlineModelUpdate = new AirlineModel(9, "fly");
            session.update("mybatis.AirlineMapper.updateAirline", airlineModelUpdate);
            System.out.println("Record updated successfully");


            //DELETE
            session.delete("mybatis.AirlineMapper.deleteAirline", 2);
            System.out.println("Record deleted successfully");


            //TERMINAL
//            TerminalModel terminalModel = new TerminalModel("T");
//            session.insert("mybatis.TerminalMapper.create", terminalModel);
//            LOGGER.info("Record inserted successfully");
//
            session.commit();
            session.close();

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
        }

    }

}
