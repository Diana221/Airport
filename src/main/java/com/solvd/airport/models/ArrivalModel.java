package com.solvd.airport.models;

public class ArrivalModel {
    private int idArrival;
    private int idAirportA;

    public ArrivalModel() {
    }

    public ArrivalModel( int idAirportA) {
        this.idAirportA = idAirportA;
    }

    public ArrivalModel(int idArrival, int idAirportA) {
        this.idArrival = idArrival;
        this.idAirportA = idAirportA;
    }

    public int getIdArrival() {
        return idArrival;
    }

    public void setIdArrival(int idArrival) {
        this.idArrival = idArrival;
    }

    public int getIdAirportA() {
        return idAirportA;
    }

    public void setIdAirportA(int idAirportA) {
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
