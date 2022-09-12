package com.solvd.airport.models;

public class FlightModel {
    private int idFlight;
    private AirlineModel idAirlineF;
    private ScheduleFlightModel idSchedule;

    public FlightModel() {
    }

    public FlightModel(int idFlight, AirlineModel idAirlineF, ScheduleFlightModel idSchedule) {
        this.idFlight = idFlight;
        this.idAirlineF = idAirlineF;
        this.idSchedule = idSchedule;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public AirlineModel getIdAirlineF() {
        return idAirlineF;
    }

    public void setIdAirlineF(AirlineModel idAirlineF) {
        this.idAirlineF = idAirlineF;
    }

    public ScheduleFlightModel getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(ScheduleFlightModel idSchedule) {
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
