package com.solvd.airport.models;

public class TerminalModel {
    private int idTerminal;
    private String terminalName;

    public TerminalModel() {
    }

    public TerminalModel(int idTerminal, String terminalName) {
        this.idTerminal = idTerminal;
        this.terminalName = terminalName;
    }

    public int getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(int idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public String toString() {
        return "TerminalModel{" +
                "idTerminal=" + getIdTerminal() +
                ", terminalName='" + getTerminalName() + '\'' +
                '}';
    }
}
