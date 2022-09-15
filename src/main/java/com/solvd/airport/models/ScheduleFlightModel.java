package com.solvd.airport.models;

public class ScheduleFlightModel {
    private int idSchedule;
    private double duration;
    private int idDeparture;
    private int idArrival;

    public ScheduleFlightModel() {
    }

    public ScheduleFlightModel(double duration, int idDeparture, int idArrival) {
        this.duration = duration;
        this.idDeparture = idDeparture;
        this.idArrival = idArrival;
    }

    public ScheduleFlightModel(int idSchedule, double duration, int idDeparture, int idArrival) {
        this.idSchedule = idSchedule;
        this.duration = duration;
        this.idDeparture = idDeparture;
        this.idArrival = idArrival;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(int idDeparture) {
        this.idDeparture = idDeparture;
    }

    public int getIdArrival() {
        return idArrival;
    }

    public void setIdArrival(int idArrival) {
        this.idArrival = idArrival;
    }

    @Override
    public String toString() {
        return "ScheduleFlightModel{" +
                "IdSchedule=" + getIdSchedule() +
                ", duration=" + getDuration() +
                ", idDeparture=" + getIdDeparture() +
                ", idArrival=" + getIdArrival() +
                '}';
    }
}
