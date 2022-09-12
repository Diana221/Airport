package com.solvd.airport.models;

public class PilotsModel {
    private int idPilot;
    private String Pname;
    private String surname;
    private int salary;
    private PlaneModel idPlane;

    public PilotsModel() {
    }

    public PilotsModel(int idPilot, String pname, String surname, int salary, PlaneModel idPlane) {
        this.idPilot = idPilot;
        Pname = pname;
        this.surname = surname;
        this.salary = salary;
        this.idPlane = idPlane;
    }

    public int getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public PlaneModel getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(PlaneModel idPlane) {
        this.idPlane = idPlane;
    }

    @Override
    public String toString() {
        return "PilotsModel{" +
                "IdPilot=" + getIdPilot() +
                ", Pname='" + getPname() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", salary=" + getSalary() +
                ", idPlane=" + getIdPlane() +
                '}';
    }
}
