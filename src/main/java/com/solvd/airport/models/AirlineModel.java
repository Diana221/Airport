package com.solvd.airport.models;

public class AirlineModel {
private int idAirline;
private String nameAirline;

    public AirlineModel() {
    }

    public AirlineModel(int idAirline, String nameAirline) {
        this.idAirline = idAirline;
        this.nameAirline = nameAirline;
    }
    public AirlineModel( String nameAirline) {
        this.nameAirline = nameAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public String getNameAirline() {
        return nameAirline;
    }


    @Override
    public String toString() {
        return "AirlineModel{" +
                "idAirline=" + getIdAirline() +
                ", nameAirline='" + getNameAirline() + '\'' +
                '}';
    }
}
