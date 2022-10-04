package com.solvd.airport.services.User;

import com.solvd.airport.dao.jdbc.mysql.PassengersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void User() throws IOException {

        Scanner name_ = new Scanner(System.in);
        LOGGER.info("\nEnter your name:");
        String name = name_.next();
        Scanner surname_ = new Scanner(System.in);
        LOGGER.info("\nEnter your surname:");
        String surname = surname_.next();

        Scanner phone_ = new Scanner(System.in);
        LOGGER.info("\nEnter your phone number:");
        String phone = phone_.next();
        Scanner email_ = new Scanner(System.in);
        LOGGER.info("\nEnter your email:");
        String email = email_.next();

        CreateNew.CreateNewPassenger(name, surname, phone, email);

        ShowTables.ShowLocation();
        LOGGER.info(name + " " + surname + ", to buy Ticket enter some information:");
        LOGGER.info("\nFROM(Enter ID):");
        Scanner from_ = new Scanner(System.in);
        int from = from_.nextInt();
        LOGGER.info("\nTO(Enter ID):");
        Scanner to_ = new Scanner(System.in);
        int to = to_.nextInt();

        LOGGER.info(name + " " + surname + ", you bought a ticket:\n");

        //CreateNew.CreateNewTicket(id);
   }
}
