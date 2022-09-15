package com.solvd.airport.models;

public class BaggagesModel {
    private int idBaggage;
    private int idPassenger;

    public BaggagesModel() {
    }

    public BaggagesModel(int idBaggage, int idPassenger) {
        this.idBaggage = idBaggage;
        this.idPassenger = idPassenger;
    }

    public BaggagesModel(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public int getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(int idBaggage) {
        this.idBaggage = idBaggage;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
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
