package com.solvd.airport.models;

public class MissingBaggagesModel {
    private int idMissingBaggage;
    private BaggagesModel idBaggage;
    private String statusB;
    private String descriptionB;

    public MissingBaggagesModel() {
    }

    public MissingBaggagesModel(int idMissingBaggage, BaggagesModel idBaggage, String statusB, String descriptionB) {
        this.idMissingBaggage = idMissingBaggage;
        this.idBaggage = idBaggage;
        this.statusB = statusB;
        this.descriptionB = descriptionB;
    }

    public int getIdMissingBaggage() {
        return idMissingBaggage;
    }

    public void setIdMissingBaggage(int idMissingBaggage) {
        this.idMissingBaggage = idMissingBaggage;
    }

    public BaggagesModel getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(BaggagesModel idBaggage) {
        this.idBaggage = idBaggage;
    }

    public String getStatusB() {
        return statusB;
    }

    public void setStatusB(String statusB) {
        this.statusB = statusB;
    }

    public String getDescriptionB() {
        return descriptionB;
    }

    public void setDescriptionB(String descriptionB) {
        this.descriptionB = descriptionB;
    }

    @Override
    public String toString() {
        return "MissingBaggagesModel{" +
                "IdMissingBaggage=" + getIdMissingBaggage() +
                ", idBaggage=" + getIdBaggage() +
                ", statusB='" + getStatusB() + '\'' +
                ", descriptionB='" + getDescriptionB() + '\'' +
                '}';
    }
}
