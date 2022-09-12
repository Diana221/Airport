package com.solvd.airport.models;

public class DepartureModel {
    private int idDeparture;
    private AirportModel idAirport;

    public DepartureModel() {
    }

    public DepartureModel(int idDeparture, AirportModel idAirport) {
        this.idDeparture = idDeparture;
        this.idAirport = idAirport;
    }

    public int getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(int idDeparture) {
        this.idDeparture = idDeparture;
    }

    public AirportModel getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(AirportModel idAirport) {
        this.idAirport = idAirport;
    }

    @Override
    public String toString() {
        return "DepartureModel{" +
                "idDeparture=" + getIdDeparture() +
                ", idAirport=" + getIdAirport() +
                '}';
    }
}
