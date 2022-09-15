package com.solvd.airport.models;

public class PlaneModel {
    private int idPlane;
    private int idAirline;

    public PlaneModel() {
    }

    public PlaneModel(int idPlane, int idAirline) {
        this.idPlane = idPlane;
        this.idAirline = idAirline;
    }

    public PlaneModel(int idAirline) {
        this.idAirline = idAirline;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
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
