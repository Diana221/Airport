package com.solvd.airport.models;

public class PilotsModel {
    private int idPilot;
    private String pName;
    private String surname;
    private int salary;
    private int idPlane;

    public PilotsModel() {
    }

    public PilotsModel(int idPilot, String pName, String surname, int salary, int idPlane) {
        this.idPilot = idPilot;
        this.pName = pName;
        this.surname = surname;
        this.salary = salary;
        this.idPlane = idPlane;
    }

    public PilotsModel(String pName, String surname, int salary, int idPlane) {
        this.pName = pName;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
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
