package com.solvd.airport.models;

public class ArrivalModel {
    private int idArrival;
    private AirportModel idAirportA;

    public ArrivalModel() {
    }

    public ArrivalModel( AirportModel idAirportA) {
        this.idAirportA = idAirportA;
    }

    public int getIdArrival() {
        return idArrival;
    }

    public void setIdArrival(int idArrival) {
        this.idArrival = idArrival;
    }

    public AirportModel getIdAirportA() {
        return idAirportA;
    }

    public void setIdAirportA(AirportModel idAirportA) {
        this.idAirportA = idAirportA;
    }

    @Override
    public String toString() {
        return "ArrivalModel{" +
                "idArrival=" + getIdArrival() +
                ", idAirportA=" + getIdAirportA() +
                '}';
    }
}
