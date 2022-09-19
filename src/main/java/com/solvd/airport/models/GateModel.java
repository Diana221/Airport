package com.solvd.airport.models;



public class GateModel {
    private int idGate;
    private int gateNumber;

    public GateModel() {
    }

    public GateModel(int idGate, int gateNumber) {
        this.idGate = idGate;
        this.gateNumber = gateNumber;
    }

    public GateModel( int gateNumber) {
        this.gateNumber = gateNumber;
    }
    public int getIdGate() {
        return idGate;
    }

    public void setIdGate(int idGate) {
        this.idGate = idGate;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    @Override
    public String toString() {
        return "GateModel{" +
                "IdGate=" + getIdGate() +
                ", gateNumber=" + getGateNumber() +
                '}';
    }
}
