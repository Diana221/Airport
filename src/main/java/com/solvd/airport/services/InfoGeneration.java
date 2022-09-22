package com.solvd.airport.services;

import com.solvd.airport.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.File;
import java.util.Scanner;

public class InfoGeneration {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());


    static public void Greetings() throws NoSuchFieldException, IllegalAccessException {
        boolean enter = true;
        int input;
        LOGGER.info("Hello!");
        do {
            LOGGER.info("\nEnter to log in\n" +
                    "1 -> as customer;\n" +
                    "2 -> as admin.\n" +
                    "3 <- to end.\n");
            Scanner input_ = new Scanner(System.in);

            if (input_.hasNextInt()) {
                input = input_.nextInt();
                if (input == 1 || input == 2) {
                    switch (input) {
                        case 1: {
                            LOGGER.info("user");
                            break;
                        }
                        case 2: {
                            Admin();
                            break;
                        }
                        case 3: {
                            LOGGER.info("Bye!");

                            break;
                        }
                        default: {
                            enter = false;
                        }
                    }
                }
            } else {
                enter = false;
            }
        }
        while (!enter);
    }






        public static void Admin() throws NoSuchFieldException, IllegalAccessException {
            int number;
        do {
                Scanner number_ = new Scanner(System.in);
                LOGGER.info("\nEnter:\n" +
                        "1 -> show;\n" +
                        "2 -> find;\n" +
                        "3 -> show last ticket;\n" +
                        "0 <- exit;\n"
                );
                if (number_.hasNextInt()) {
                    number = number_.nextInt();

                    switch (number) {
                        case 1: {
                            Show();
                            break;
                        }
                        case 2: {
                           // FindInfo();
                            LOGGER.info("FIND");
                            break;
                        }
                        case 3: {
                            break;
                        }
                        case 0: {
                            Greetings();
                            break;
                        }
                    }
                } else {
                    number = 1;
                }
            }
            while (number != 0);
        }



    public static void Show() {
        int number = 0;
        try {
            do {
                Scanner number_ = new Scanner(System.in);
                LOGGER.info("\nTo show:\n" +
                        "1 -> passengers;\n" +
                        "2 -> tickets;\n" +
                        "3 -> baggages;\n" +
                        "4 -> missing baggages;\n" +
                        "0 <- back;\n"
                );
                if (number_.hasNextInt()) {
                    number = number_.nextInt();

                    switch (number) {
//                        case 1: {
//                            CustomerInfo();
//                            break;
//                        }
//                        case 2: {
//                            StudioInfo();
//                            break;
//                        }
//                        case 3: {
//                            PhotographerInfo();
//                            break;
//                        }
//                        case 4: {
//                            ModelingAgencyInfo();
//                            break;
//                        }
//                        case 0: {
//                            Admin();
//                            break;
//                        }
                    }
                }
            }
            while (number != 0);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }



//    static public void User() {
//        int number, age = 0, index = 0;
//        String customerNote = "";
//        String purchase = "";
//        boolean sameCustomer = false;
//        boolean phone = true;
//        boolean customerAge = true;
//        String phoneNumber = null;
//        Customer customer_now;
//
//        Scanner name_ = new Scanner(System.in);
//        logger.info("\nEnter your name:");
//        String name = name_.next();
//        Scanner surname_ = new Scanner(System.in);
//        logger.info("\nEnter your surname:");
//        String surname = surname_.next();
//        final File file = new File(path);
//        for (int i = 0; i < GenerationCustomerInfo().size(); i++) {
//            if (GenerationCustomerInfo().get(i).getName().equals(name) &&
//                    GenerationCustomerInfo().get(i).getSurname().equals(surname)) {
//                sameCustomer = true;
//                index = i;
//            }
//        }
//
//        if (!sameCustomer) {
//            logger.info("\nWe need to add some information about you!");
//            do {
//                Scanner phoneNumber_ = new Scanner(System.in);
//                logger.info("Enter your phone number(format 0987671616):");
//                try {
//                    phoneNumber = phoneNumber_.next();
//                    if (!phoneNumber.matches("[-+]?\\d+") && phoneNumber.length() != 10) {
//                        throw new WrongPhoneNumberException();
//                    } else {
//                        phone = false;
//                    }
//                } catch (WrongPhoneNumberException ex) {
//                    logger.info(ex.getMessage());
//                }
//            }
//            while (phone);
//            do {
//                Scanner age_ = new Scanner(System.in);
//                logger.info("\nEnter your age:");
//                try {
//                    if (age_.hasNextInt()) {
//                        age = age_.nextInt();
//                        if (age < 18 || age > 100) {
//                            throw new WrongAgeException();
//                        } else {
//                            customerAge = false;
//                        }
//                    }
//                } catch (WrongAgeException e) {
//                    logger.info(e.getMessage());
//                }
//            }
//            while (customerAge);
//            customer_now = new Customer(name, surname, phoneNumber, age, false);
//        } else {
//            customer_now = GenerationCustomerInfo().get(index);
//        }
//        try {
//            do {
//                Scanner number_ = new Scanner(System.in);
//                logger.info("\n" + customer_now.getName() + " " + customer_now.getSurname() +
//                        ", Enter:\n" +
//                        "1 -> to rent a photographer;\n" +
//                        "2 -> to rent a studio;\n" +
//                        "3 -> to buy a photo shoot;\n" +
//                        "4 -> to have a call back;\n" +
//                        "5 -> to enter notes;\n" +
//                        "0 <- exit."
//                );
//                if (number_.hasNextInt()) {
//                    number = number_.nextInt();
//
//                    switch (number) {
//                        case 1: {
//                            purchase = customer_now + "\nRented " +
//                                    customer_now.rentPhotographer() + "\n";
//                            FileUtils.writeStringToFile(file, purchase + "\n" +
//                                    customerNote, "ISO-8859-1");
//
//                            break;
//                        }
//                        case 2: {
//                            purchase = customer_now + "\nRented studio number " +
//                                    customer_now.rentStudio();
//                            FileUtils.writeStringToFile(file, purchase + "\n" + customerNote,
//                                    "ISO-8859-1");
//
//                            break;
//                        }
//                        case 3: {
//                            purchase = customer_now + "\n" + customer_now.photoShoot();
//                            FileUtils.writeStringToFile(file, purchase +
//                                    "\n" + customerNote, "ISO-8859-1");
//
//                            break;
//                        }
//                        case 4: {
//                            customer_now.callBack(customer_now);
//                            break;
//                        }
//                        case 5: {
//                            Scanner note_ = new Scanner(System.in);
//                            logger.info("\nEnter your note:");
//                            String note = note_.nextLine();
//                            if (StringUtils.isEmpty(note)) {
//                                logger.info("Empty note");
//                            } else {
//                                logger.info("Your note: " + StringUtils.normalizeSpace(note));
//                                FileUtils.writeStringToFile(file, purchase + "\nNoted: " +
//                                        StringUtils.normalizeSpace(note), "ISO-8859-1");
//                                customerNote = "\nNoted: " + StringUtils.normalizeSpace(note);
//                            }
//                            break;
//                        }
//                        case 0: {
//                            //Lambda Expression
//                            IByeMessage bye = () -> "\nThank you!";
//                            logger.info(bye.bye());
//                            Studio.show("We do not work on Wednesdays");
//                            Greetings();
//                            break;
//                        }
//                    }
//                } else {
//                    number = 1;
//                }
//            }
//            while (number != 0);
//        } catch (Exception ex) {
//            logger.error(ex.getMessage());
//        }
//    }



}
