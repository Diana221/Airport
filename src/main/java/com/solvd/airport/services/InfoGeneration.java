package com.solvd.airport.services;

import com.solvd.airport.Main;
import com.solvd.airport.dao.IArrivalDAO;
import com.solvd.airport.dao.jdbc.mysql.ArrivalDAO;
import com.solvd.airport.models.LocationModel;
import com.solvd.airport.models.PassengersModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class InfoGeneration {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());







public static void User() throws IOException {


    Scanner name_ = new Scanner(System.in);
    LOGGER.info("\nEnter your name:");
    String name = name_.next();
    Scanner surname_ = new Scanner(System.in);
    LOGGER.info("\nEnter your surname:");
    String surname = surname_.next();


    IArrivalDAO iArrival = new ArrivalDAO();
    LOGGER.info("\nTo buy Ticket enter some information:");







}





}
