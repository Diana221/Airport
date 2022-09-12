package com.solvd.airport.models;

public class PassengersModel {
    private int idPassenger;
    private String Pname;
    private String surname;
    private String phoneNumber;
    private String email;
    private FlightModel idFlight;

    public PassengersModel() {
    }

    public PassengersModel(int idPassenger, String pname, String surname, String phoneNumber, String email, FlightModel idFlight) {
        this.idPassenger = idPassenger;
        Pname = pname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idFlight = idFlight;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FlightModel getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(FlightModel idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public String toString() {
        return "PassengersModel{" +
                "IdPassenger=" + getIdPassenger() +
                ", Pname='" + getPname() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", phoneNumber='" +  getPhoneNumber()+ '\'' +
                ", email='" +  getEmail() + '\'' +
                ", idFlight=" + getIdFlight() +
                '}';
    }
}
