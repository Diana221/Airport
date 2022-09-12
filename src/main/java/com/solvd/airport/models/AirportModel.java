package com.solvd.airport.models;

public class AirportModel {
    private int idAirport;
    private String airportName;
    private LocationModel idLocation;
    private GateModel idGate;
    private TerminalModel idTerminal;

    public AirportModel() {
    }

    public AirportModel(int idAirport, String airportName, LocationModel idLocation, GateModel idGate, TerminalModel idTerminal) {
        this.idAirport = idAirport;
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

    public LocationModel getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(LocationModel idLocation) {
        this.idLocation = idLocation;
    }

    public GateModel getIdGate() {
        return idGate;
    }

    public void setIdGate(GateModel idGate) {
        this.idGate = idGate;
    }

    public TerminalModel getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(TerminalModel idTerminal) {
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
