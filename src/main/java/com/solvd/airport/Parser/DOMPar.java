package com.solvd.airport.Parser;

import com.solvd.airport.dao.IAirlineDAO;
import com.solvd.airport.dao.ILocationDAO;
import com.solvd.airport.dao.jdbc.mysql.AirlineDAO;
import com.solvd.airport.dao.jdbc.mysql.LocationDAO;
import com.solvd.airport.models.AirlineModel;
import com.solvd.airport.models.LocationModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMPar {


    //AIRLINE
    public static void addAirlines() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/XML/airline.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("airline");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                AirlineModel airlineModel =
                        new AirlineModel(eElement.getElementsByTagName("nameAirline").item(0).getTextContent());

                IAirlineDAO iAirlineCreate = new AirlineDAO();
                iAirlineCreate.createAirline(airlineModel);
            }
        }
    }


    //LOCATION
    public static void addLocations() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/XML/location.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("location");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                LocationModel locationModel =
                        new LocationModel(eElement.getElementsByTagName("country").item(0).getTextContent(),
                                eElement.getElementsByTagName("city").item(0).getTextContent());

                ILocationDAO iLocationCreate = new LocationDAO();
                iLocationCreate.createLocation(locationModel);
            }
        }
    }

}
