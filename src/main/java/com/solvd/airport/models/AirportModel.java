package com.solvd.airport.models;

public class AirportModel {
    private int idAirport;
    private String airportName;
    private int idLocation;
    private int idGate;
    private int idTerminal;

    public AirportModel() {
    }

    public AirportModel(int idAirport, String airportName, int idLocation, int idGate, int idTerminal) {
        this.idAirport = idAirport;
        this.airportName = airportName;
        this.idLocation = idLocation;
        this.idGate = idGate;
        this.idTerminal = idTerminal;
    }


    public AirportModel(String airportName, int idLocation, int idGate, int idTerminal) {
        this.airportName = airportName;
        this.idLocation = idLocation;
        this.idGate = idGate;
        this.idTerminal = idTerminal;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdGate() {
        return idGate;
    }

    public void setIdGate(int idGate) {
        this.idGate = idGate;
    }

    public int getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(int idTerminal) {
        this.idTerminal = idTerminal;
    }

    @Override
    public String toString() {
        return "AirportModel{" +
                "idAirport=" + getIdAirport() +
                ", airportName='" + getAirportName() + '\'' +
                ", idLocation=" + getIdLocation() +
                ", idGate=" + getIdGate() +
                ", idTerminal=" + getIdTerminal() +
                '}';
    }
}
