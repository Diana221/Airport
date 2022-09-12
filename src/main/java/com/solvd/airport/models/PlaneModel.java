package com.solvd.airport.models;

public class PlaneModel {
    private int idPlane;
    private AirlineModel idAirline;

    public PlaneModel() {
    }

    public PlaneModel(int idPlane, AirlineModel idAirline) {
        this.idPlane = idPlane;
        this.idAirline = idAirline;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public AirlineModel getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(AirlineModel idAirline) {
        this.idAirline = idAirline;
    }

    @Override
    public String toString() {
        return "PlaneModel{" +
                "idPlane=" + getIdPlane() +
                ", idAirline=" + getIdAirline() +
                '}';
    }
}
