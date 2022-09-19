package com.solvd.airport.Parser;


import com.solvd.airport.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;


public class JABXTest {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    private static final String XML_PATH_COUNTRY = "src/main/resources/XML/country.xml";
    private static final String XML_PATH_COUNTRIES = "src/main/resources/XML/countries.xml";

    public static void main(String[] args) throws JAXBException {
        Country spain = new Country();
        spain.setCountry("Spain");
        spain.setCity("Madrid");

        Country america = new Country();
        america.setCountry("USA");
        america.setCity("New York");


        File xmlFile = new File(XML_PATH_COUNTRY);
        File xmlFile1 = new File(XML_PATH_COUNTRIES);

        LOGGER.info("\n Write to [country]");
        JAXBPar.writeXML(spain, xmlFile, Country.class);


        LOGGER.info("\n Write to [countries]");
        Countries countries = new Countries();
        ArrayList<Country> list = new ArrayList<>();
        list.add(spain);
        list.add(america);
        countries.setCountries(list);
        JAXBPar.writeXML(countries, xmlFile1, Countries.class);


        Country countryRead = (Country) JAXBPar.readXML(xmlFile, Country.class);
        LOGGER.info("\n Read from [country]: " + countryRead);

        Countries countriesRead = (Countries) JAXBPar.readXML(xmlFile1, Countries.class, Country.class);
        LOGGER.info("\n Read from [countries]: " + countriesRead);




    }

}
