package com.solvd.airport.Parser.DOM;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"country", "city"})
@XmlRootElement(name = "Country")
public class Country {

    private String country;
    private String city;




    public String getCountry() {
        return country;
    }

    @XmlElement(name = "Country")
    public void setCountry(String name) {
        this.country = name;
    }

    public String getCity() {
        return city;
    }

    @XmlElement(name = "City")
    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "{Country=" + this.getCountry() +
                ", City=" + this.getCity()+"}";
    }

}
