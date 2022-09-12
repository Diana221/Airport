package com.solvd.airport.models;

public class ScheduleFlightModel {
    private int idSchedule;
    private double duration;
    private DepartureModel idDeparture;
    private ArrivalModel idArrival;

    public ScheduleFlightModel() {
    }

    public ScheduleFlightModel(int idSchedule, double duration, DepartureModel idDeparture, ArrivalModel idArrival) {
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

    public DepartureModel getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(DepartureModel idDeparture) {
        this.idDeparture = idDeparture;
    }

    public ArrivalModel getIdArrival() {
        return idArrival;
    }

    public void setIdArrival(ArrivalModel idArrival) {
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
