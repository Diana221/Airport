package com.solvd.airport.Parser.DOM;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomTest {

    public static void main(String[] args) throws  IOException, SAXException, ParserConfigurationException {

        DOMPar.addAirlines(); // airline.xml
        DOMPar.addLocations(); // location.xml

    }
}
