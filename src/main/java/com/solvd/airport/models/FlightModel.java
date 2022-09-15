package com.solvd.airport.models;

public class FlightModel {
    private int idFlight;
    private int idAirlineF;
    private int idSchedule;

    public FlightModel() {
    }

    public FlightModel(int idFlight, int idAirlineF, int idSchedule) {
        this.idFlight = idFlight;
        this.idAirlineF = idAirlineF;
        this.idSchedule = idSchedule;
    }

    public FlightModel(int idAirlineF, int idSchedule) {
        this.idAirlineF = idAirlineF;
        this.idSchedule = idSchedule;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getIdAirlineF() {
        return idAirlineF;
    }

    public void setIdAirlineF(int idAirlineF) {
        this.idAirlineF = idAirlineF;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public String toString() {
        return "FlightModel{" +
                "IdFlight=" + getIdFlight() +
                ", idAirlineF=" + getIdAirlineF() +
                ", idSchedule=" + getIdSchedule() +
                '}';
    }
}
