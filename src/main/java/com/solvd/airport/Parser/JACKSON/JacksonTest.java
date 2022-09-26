package com.solvd.airport.Parser.JACKSON;

import com.solvd.airport.Parser.Countries;
import com.solvd.airport.Parser.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JacksonTest {

    private static final Logger LOGGER = LogManager.getLogger(JacksonTest.class.getName());

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        Countries country = create();

        try {
            LOGGER.info("\n Successfully written to [countries]!");
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/JSON/countries.json"), country);
            LOGGER.info("\n Read from [countries]: ");
            Countries countries = mapper.readValue(new File("src/main/resources/JSON/countries.json"), Countries.class);
            LOGGER.info(countries);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Countries create() {

        Country ukraine = new Country();
        Country spain = new Country();

        ukraine.setCountry("Ukraine");
        ukraine.setCity("Kharkiv");

        spain.setCountry("Spain");
        spain.setCity("Madrid");

        Countries countries = new Countries();
        ArrayList<Country> list = new ArrayList<>();
        list.add(ukraine);
        list.add(spain);
        countries.setCountries(list);

        return countries;
    }
}
