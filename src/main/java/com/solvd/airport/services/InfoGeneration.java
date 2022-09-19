package com.solvd.airport.services;

import com.solvd.airport.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
                    "2 -> as admin.\n");
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
                            LOGGER.info("admin");
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





}
