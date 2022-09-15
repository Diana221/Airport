package com.solvd.airport.models;

public class TicketModel {
    private int idTicket;
    private int idPassengerT;
    private String seat;
    private int price;

    public TicketModel() {
    }

    public TicketModel(int idPassengerT, String seat, int price) {
        this.idPassengerT = idPassengerT;
        this.seat = seat;
        this.price = price;
    }

    public TicketModel(int idTicket, int idPassengerT, String seat, int price) {
        this.idTicket = idTicket;
        this.idPassengerT = idPassengerT;
        this.seat = seat;
        this.price = price;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdPassengerT() {
        return idPassengerT;
    }

    public void setIdPassengerT(int idPassengerT) {
        this.idPassengerT = idPassengerT;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketModel{" +
                "IdTicket=" + getIdTicket() +
                ", idPassengerT=" + getIdPassengerT() +
                ", seat='" + getSeat() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
