package com.solvd.airport.services.User;

import com.solvd.airport.dao.IPassengersDAO;
import com.solvd.airport.dao.ITicketDAO;
import com.solvd.airport.dao.jdbc.mysql.PassengersDAO;
import com.solvd.airport.dao.jdbc.mysql.TicketDAO;
import com.solvd.airport.models.PassengersModel;
import com.solvd.airport.models.TicketModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateNew {

    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void CreateNewTicket(int idP) {
        ITicketDAO iTicketDAO = new TicketDAO();
        LOGGER.info(idP);
        iTicketDAO.create(new TicketModel(idP, "4D", 400));
        iTicketDAO.getById(idP);
    }

    public static void CreateNewPassenger(String name, String surname, String phoneNumber, String email) {
        IPassengersDAO iPassengerDAO = new PassengersDAO();
        iPassengerDAO.create(new PassengersModel(name, surname, phoneNumber, email, 13));
    }
}
