package com.solvd.airport.models;

public class DepartureModel {
    private int idDeparture;
    private int idAirport;

    public DepartureModel() {
    }

    public DepartureModel(int idDeparture, int idAirport) {
        this.idDeparture = idDeparture;
        this.idAirport = idAirport;
    }

    public DepartureModel(int idAirport) {
        this.idAirport = idAirport;
    }

    public int getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(int idDeparture) {
        this.idDeparture = idDeparture;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
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
