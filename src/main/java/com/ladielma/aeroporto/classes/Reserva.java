package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Reserva {
    private String idReserva;
    private String idVoo;
    private StatusViajante status;
    private Comprador comprador;
    private ArrayList<Viajante> viajantes;
    private String[] assentos;

    public Reserva(String idReserva, String idVoo, StatusViajante status, Comprador comprador,
            ArrayList<Viajante> viajantes, String[] assentos) {
        this.idReserva = idReserva;
        this.idVoo = idVoo;
        this.status = status;
        this.comprador = comprador;
        this.viajantes = viajantes;
        this.assentos = assentos;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public String getIdVoo() {
        return idVoo;
    }

    public StatusViajante getStatus() {
        return status;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public ArrayList<Viajante> getViajantes() {
        return viajantes;
    }

    public String[] getAssentos() {
        return assentos;
    }

}