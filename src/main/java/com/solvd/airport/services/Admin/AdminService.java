package com.solvd.airport.services.Admin;

import com.solvd.airport.ReflectionAdmin.ReflectionAdmin;
import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.IGateDAO;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.dao.ITerminalDAO;
import com.solvd.airport.dao.mybatis.mysql.AirlineDao;
import com.solvd.airport.dao.mybatis.mysql.GateDao;
import com.solvd.airport.dao.mybatis.mysql.LocationDao;
import com.solvd.airport.dao.mybatis.mysql.TerminalDao;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.GateModel;
import com.solvd.airport.models.LocationModel;
import com.solvd.airport.models.TerminalModel;
import com.solvd.airport.services.User.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AdminService {
    private static final Logger LOGGER = LogManager.getLogger(User.class.getName());

    public static void AdminChoose() {

        Scanner choose_ = new Scanner(System.in);
        LOGGER.info("\n1 -> to show " +
                "\n2 -> to add new" +
                "\n3 -> to update " +
                "\n4 -> to delete" +
                "\n5 -> to find");
        int choose = choose_.nextInt();

        switch (choose) {
            case 1: {
                ChooseOne();
                break;
            }
            case 2: {
                ChooseTwo();
                break;
            }
            case 3: {
                ChooseThree();
                break;
            }
            case 4: {
                ChooseFour();
                break;
            }
            case 5: {
                ChooseFive();
                break;
            }
        }
    }

    public static void Greeting() throws IllegalAccessException, NoSuchFieldException {
        boolean admin = false;

        do {
            Scanner login_ = new Scanner(System.in);
            LOGGER.info("\nlogin:");
            String login = login_.next();
            Scanner password_ = new Scanner(System.in);
            LOGGER.info("\npassword:");
            String password = password_.next();

            if (login.contains(ReflectionAdmin.getAdminLogin()) &&
                    password.contains(ReflectionAdmin.getAdminPassword())) {
                admin = true;
                try {
                    AdminChoose();
                } catch (Exception ex) {
                    LOGGER.error(ex.getMessage());
                }
            } else {
                LOGGER.error("Incorrect login or password!");
            }
        }
        while (!admin);
    }

    public static void ChooseOne() {
        Scanner one_ = new Scanner(System.in);
        LOGGER.info("\nShow:" + "\n1 -> airlines " +
                "\n2 -> gates" +
                "\n3 -> location " +
                "\n4 -> terminal" +
                "\n5 <- back");
        int one = one_.nextInt();

        switch (one) {
            case 1: {
                IAirlineDAO iAirline = new AirlineDao();
                iAirline.getAll();
                ChooseOne();
                break;
            }
            case 2: {
                IGateDAO iGate = new GateDao();
                iGate.getAll();
                ChooseOne();
                break;
            }
            case 3: {
                ILocationDAO iLocation = new LocationDao();
                iLocation.getAllLocation();
                ChooseOne();
                break;
            }
            case 4: {
                ITerminalDAO iTerminal = new TerminalDao();
                iTerminal.getAll();
                ChooseOne();
                break;
            }
            case 5: {
                AdminChoose();
            }

        }
    }

    public static void ChooseTwo() {
        Scanner one_ = new Scanner(System.in);
        LOGGER.info("\nAdd:" + "\n1 -> airlines " +
                "\n2 -> gates" +
                "\n3 -> location " +
                "\n4 -> terminal" +
                "\n5 <- back");
        int one = one_.nextInt();

        switch (one) {
            case 1: {
                try {
                    Scanner name_ = new Scanner(System.in);
                    LOGGER.info("\nEnter Airline Name:");
                    String name = name_.next();
                    IAirlineDAO iAirline = new AirlineDao();
                    iAirline.createAirline(new AirlineModel(name));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseTwo();
                }
                AdminChoose();
                break;
            }
            case 2: {
                try {
                    Scanner number_ = new Scanner(System.in);
                    LOGGER.info("\nEnter Gate Number:");
                    int number = number_.nextInt();
                    IGateDAO iGate = new GateDao();
                    iGate.create(new GateModel(number));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseTwo();
                }
                AdminChoose();
                break;
            }
            case 3: {
                try {
                    Scanner country_ = new Scanner(System.in);
                    LOGGER.info("\nEnter country:");
                    String country = country_.next();
                    Scanner city_ = new Scanner(System.in);
                    LOGGER.info("\nEnter city:");
                    String city = city_.next();
                    ILocationDAO iLocation = new LocationDao();
                    iLocation.createLocation(new LocationModel(country, city));

                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseTwo();
                }
                AdminChoose();
                break;
            }
            case 4: {
                try {
                    Scanner name_ = new Scanner(System.in);
                    LOGGER.info("\nEnter Terminal Name:");
                    String name = name_.next();
                    ITerminalDAO iTerminal = new TerminalDao();
                    iTerminal.create(new TerminalModel(name));

                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseTwo();
                }
                AdminChoose();
                break;
            }
            case 5: {
                AdminChoose();
            }
        }
    }

    public static void ChooseThree() {
        Scanner one_ = new Scanner(System.in);
        LOGGER.info("\nUpdate:" + "\n1 -> airlines " +
                "\n2 -> gates" +
                "\n3 -> location " +
                "\n4 -> terminal" +
                "\n5 <- back");
        int one = one_.nextInt();

        switch (one) {
            case 1: {
                IAirlineDAO iAirline = new AirlineDao();
                iAirline.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter airline ID:");
                int id = id_.nextInt();
                try {
                    Scanner name_ = new Scanner(System.in);
                    LOGGER.info("\nEnter new Airline Name:");
                    String name = name_.next();
                    // IAirlineDAO iAirline = new AirlineDao();
                    iAirline.updateAirline(new AirlineModel(id, name));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseThree();
                }
                AdminChoose();
                break;
            }
            case 2: {
                IGateDAO iGate = new GateDao();
                iGate.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter gate ID:");
                int id = id_.nextInt();
                try {
                    Scanner name_ = new Scanner(System.in);
                    LOGGER.info("\nEnter new Gate Number:");
                    int gateNumber = name_.nextInt();
                    //IGateDAO iGate = new GateDao();
                    iGate.update(new GateModel(id, gateNumber));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseThree();
                }
                AdminChoose();
                break;
            }
            case 3: {
                IAirlineDAO iAirlineDAO = new AirlineDao();
                iAirlineDAO.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter airline ID:");
                int id = id_.nextInt();
                try {
                    Scanner country_ = new Scanner(System.in);
                    LOGGER.info("\nEnter new country:");
                    String country = country_.next();
                    Scanner city_ = new Scanner(System.in);
                    LOGGER.info("\nEnter new city:");
                    String city = city_.next();
                    ILocationDAO iLocation = new LocationDao();
                    iLocation.updateLocation(new LocationModel(id, country, city));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseThree();
                }
                AdminChoose();
                break;
            }
            case 4: {
                ITerminalDAO iTerminal = new TerminalDao();
                iTerminal.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter Terminal ID:");
                int id = id_.nextInt();
                try {
                    Scanner terminalName_ = new Scanner(System.in);
                    LOGGER.info("\nEnter new Terminal Name:");
                    String terminalName = terminalName_.next();
                    //ITerminalDAO iTerminal = new TerminalDao();
                    iTerminal.update(new TerminalModel(id, terminalName));
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseThree();
                }
                AdminChoose();
                break;
            }
            case 5: {
                AdminChoose();
            }
        }
    }

    public static void ChooseFour() {
        Scanner one_ = new Scanner(System.in);
        LOGGER.info("\nDelete:" + "\n1 -> airlines " +
                "\n2 -> gates" +
                "\n3 -> location " +
                "\n4 -> terminal" +
                "\n5 <- back");
        int one = one_.nextInt();

        switch (one) {
            case 1: {
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter airline ID:");
                int id = id_.nextInt();
                try {
                    IAirlineDAO iAirline = new AirlineDao();
                    iAirline.deleteAirline(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFour();
                }
                AdminChoose();
                break;
            }
            case 2: {
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter Gate ID:");
                int id = id_.nextInt();
                try {
                    IGateDAO iGate = new GateDao();
                    iGate.delete(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFour();
                }
                AdminChoose();
                break;
            }
            case 3: {
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter Location ID:");
                int id = id_.nextInt();
                try {
                    ILocationDAO iLocation = new LocationDao();
                    iLocation.deleteLocation(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFour();
                }
                AdminChoose();
                break;
            }
            case 4: {
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter Terminal ID:");
                int id = id_.nextInt();
                try {
                    ITerminalDAO iTerminal = new TerminalDao();
                    iTerminal.delete(id);

                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFour();
                }
                AdminChoose();
                break;
            }
            case 5: {
                AdminChoose();
            }
        }
    }

    public static void ChooseFive() {
        Scanner one_ = new Scanner(System.in);
        LOGGER.info("\nFind:" + "\n1 -> airlines " +
                "\n2 -> gates" +
                "\n3 -> location " +
                "\n4 -> terminal" +
                "\n5 <- back");
        int one = one_.nextInt();

        switch (one) {
            case 1: {
                IAirlineDAO iAirline = new AirlineDao();
                iAirline.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter airline ID:");
                int id = id_.nextInt();
                try {
                    //  IAirlineDAO iAirline = new AirlineDao();
                    iAirline.getAirlineById(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFive();
                }
                AdminChoose();
                break;
            }
            case 2: {
                IGateDAO iGate = new GateDao();
                iGate.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter gate ID:");
                int id = id_.nextInt();
                try {
                    // IGateDAO iGate = new GateDao();
                    iGate.getById(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFive();
                }
                AdminChoose();
                break;
            }
            case 3: {
                ILocationDAO iLocation = new LocationDao();
                iLocation.getAllLocation();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter location ID:");
                int id = id_.nextInt();
                try {
                    // ILocationDAO iLocation = new LocationDao();
                    iLocation.getLocationById(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFive();
                }
                AdminChoose();
                break;
            }
            case 4: {
                ITerminalDAO iTerminal = new TerminalDao();
                iTerminal.getAll();
                Scanner id_ = new Scanner(System.in);
                LOGGER.info("\nEnter terminal ID:");
                int id = id_.nextInt();
                try {
                    // ITerminalDAO iTerminal = new TerminalDao();
                    iTerminal.getById(id);
                } catch (Exception ex) {
                    LOGGER.info(ex.getMessage());
                    ChooseFive();
                }
                AdminChoose();
                break;
            }
            case 5: {
                AdminChoose();
            }
        }
    }
}
