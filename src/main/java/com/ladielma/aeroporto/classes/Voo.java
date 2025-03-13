package com.ladielma.aeroporto.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Voo {
    private String idVoo;
    private LocalDateTime horario;
    private Terminal terminal;
    private String chegadaDestino;
    private Companhia companhia;
    private StatusVoo statusVoo;
    private Aviao aviao;
    private static ArrayList<Voo> voos = new ArrayList<Voo>();
    private Assento[] assentos;

    Companhia companhia1 = new Companhia(
        "Latam Airlines",   // Nome
        "LA",              // Código IATA
        "LAN",             // Código ICAO
        "Brasil",          // País
        "+55 11 4002-5700" // Contato
    );

    Companhia companhia2 = new Companhia(
        "Gol Linhas Aéreas", // Nome
        "G3",                // Código IATA
        "GLO",               // Código ICAO
        "Brasil",            // País
        "+55 11 5504-4410"   // Contato
    );

    Aviao aviao1 = new Aviao(
        "Boeing 737-800",  // Modelo
        "Boeing",          // Fabricante
        180,               // Capacidade total
        180,               // Quantidade total de assentos
        150,               // Assentos econômicos
        24,                // Assentos executivos
        6                  // Assentos primeira classe
    );

    Aviao aviao2 = new Aviao(
        "Airbus A320",     // Modelo
        "Airbus",          // Fabricante
        160,               // Capacidade total
        160,               // Quantidade total de assentos
        130,               // Assentos econômicos
        24,                // Assentos executivos
        6                  // Assentos primeira classe
    );

    Voo voo1 = new Voo(
            "LA1234",
            LocalDateTime.of(2025, 5, 15, 14, 30),
            Terminal.A,
            "São Paulo - GRU",
            companhia1,
            StatusVoo.CONFIRMADO,
            aviao1
        );

    public enum Terminal{
        A, B, C;
    }

    public Voo(String idVoo, LocalDateTime horario, Terminal terminal, String chegadaDestino, Companhia companhia, StatusVoo status, Aviao aviao) {
        this.idVoo = idVoo;
        this.horario = horario;
        this.terminal = terminal;
        this.chegadaDestino = chegadaDestino;
        this.companhia = companhia;
        this.statusVoo = status;
        this.aviao = aviao;
        for (int i = 0; i < aviao.getQtdAssentos(); i++) {
            this.assentos[i]= new Assento(i, false);
        }
        voos.add(this);
    }

    public void setIdVoo(String idVoo) {
        this.idVoo = idVoo;
    }

    public String getIdVoo() {
        return idVoo;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setChegadaDestino(String chegadaDestino) {
        this.chegadaDestino = chegadaDestino;
    }

    public String getChegadaDestino() {
        return chegadaDestino;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setStatusVoo(StatusVoo statusVoo) {
        this.statusVoo = statusVoo;
    }

    public StatusVoo getStatusVoo() {
        return statusVoo;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public static ArrayList<Voo> getVoos() {
        return voos;
    }

}