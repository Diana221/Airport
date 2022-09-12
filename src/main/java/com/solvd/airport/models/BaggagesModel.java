package com.solvd.airport.models;

public class BaggagesModel {
    private int idBaggage;
    private PassengersModel idPassenger;

    public BaggagesModel() {
    }

    public BaggagesModel(int idBaggage, PassengersModel idPassenger) {
        this.idBaggage = idBaggage;
        this.idPassenger = idPassenger;
    }

    public int getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(int idBaggage) {
        this.idBaggage = idBaggage;
    }

    public PassengersModel getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(PassengersModel idPassenger) {
        this.idPassenger = idPassenger;
    }

    @Override
    public String toString() {
        return "BaggagesModel{" +
                "idBaggage=" + getIdBaggage() +
                ", idPassenger=" + getIdPassenger() +
                '}';
    }
}
