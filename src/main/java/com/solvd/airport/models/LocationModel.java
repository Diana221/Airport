package com.solvd.airport.models;

public class LocationModel {
    private int idLocation;
    private String country;
    private String city;

    public LocationModel() {
    }

    public LocationModel(int idLocation, String country, String city) {
        this.idLocation = idLocation;
        this.country = country;
        this.city = city;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "IdLocation=" + getIdLocation() +
                ", country='" + getCountry() + '\'' +
                ", city='" + getCity() + '\'' +
                '}';
    }
}
