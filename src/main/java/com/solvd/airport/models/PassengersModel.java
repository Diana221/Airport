package com.solvd.airport.models;

public class PassengersModel {
    private int idPassenger;
    private String pName;
    private String surname;
    private String phoneNumber;
    private String email;
    private int idFlight;

    public PassengersModel() {
    }

    public PassengersModel(int idPassenger, String pName, String surname, String phoneNumber, String email, int idFlight) {
        this.idPassenger = idPassenger;
        this.pName = pName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idFlight = idFlight;
    }

    public PassengersModel(String pName, String surname, String phoneNumber, String email, int idFlight) {
        this.pName = pName;
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
        return pName;
    }

    public void setPname(String pName) {
        pName = pName;
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

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public String toString() {
        return "PassengersModel{" +
                "Id Passenger=" + getIdPassenger() +
                ", name='" + getPname() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", phoneNumber='" +  getPhoneNumber()+ '\'' +
                ", email='" +  getEmail() + '\'' +
                ", idFlight=" + getIdFlight() +
                '}';
    }
}
