package com.ladielma.aeroporto.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Voo {
    enum StatusVoo {
        ATRASADO, CANCELADO, CONFIRMADO, EMBARQUE_PROXIMO, EMBARQUE_IMEDIATO, POUSANDO, EM_SOLO;
    }

    private String idVoo;
    private boolean chegando;
    private LocalDateTime horario;
    private Terminal terminal;
    private String origemDestino;
    private Companhia companhia;
    private StatusVoo statusVoo;
    private Aviao aviao;
    private static ArrayList<Voo> chegadas = new ArrayList<>();
    private static ArrayList<Voo> saidas = new ArrayList<>();
    private Assento[] assentos;


    static{
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
        180,               // Quantidade total de assentos
        150,               // Assentos econômicos
        24,                // Assentos executivos
        6                  // Assentos primeira classe
    );

    Aviao aviao2 = new Aviao(
        "Airbus A320",     // Modelo
        "Airbus",          // Fabricante
        160,               // Quantidade total de assentos
        130,               // Assentos econômicos
        24,                // Assentos executivos
        6                  // Assentos primeira classe
    );

    Voo voo1 = new Voo(
            "LA1234",
            false,
            LocalDateTime.of(2025, 5, 15, 14, 30),
            Terminal.A,
            "São Paulo",
            companhia1,
            StatusVoo.CONFIRMADO,
            aviao1
        );
    
    Voo voo2 = new Voo(
        "2345", true, LocalDateTime.of(2025, 5, 14, 13, 0), Terminal.B, "Rio de Janeiro", companhia2, StatusVoo.CANCELADO, aviao2);
    }

    public enum Terminal{
        A, B, C;
    }


    public Voo(String idVoo, boolean chegando, LocalDateTime horario, Terminal terminal, String origemDestino, Companhia companhia, StatusVoo status, Aviao aviao) {
        this.idVoo = idVoo;
        this.chegando = chegando;
        if (chegando) {
            chegadas.add(this);
        } else {
            saidas.add(this);
        }
        this.horario = horario;
        this.terminal = terminal;
        this.origemDestino = origemDestino;
        this.companhia = companhia;
        this.statusVoo = status;
        this.aviao = aviao;
        this.assentos = new Assento[aviao.getQtdAssentos()];
        for (int i = 0; i < aviao.getQtdAssentos(); i++) {
            this.assentos[i]= new Assento(i+1);
        }
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

    public void setOrigemDestino(String origemDestino) {
        this.origemDestino = origemDestino;
    }

    public String getOrigemDestino() {
        return origemDestino;
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

    public Assento[] getAssentos() {
        return assentos;
    }

    public static ArrayList<Voo> getChegadas() {
        return chegadas;
    }

    public static ArrayList<Voo> getSaidas(){
        return saidas;
    }

    public boolean getChegando(){
        return chegando;
    }

    public String getStatusVooFormatado() {
        switch (statusVoo) {
            case ATRASADO:
                return "ATRASADO";
            case CANCELADO:
                return "CANCELADO";
            case CONFIRMADO:
                return "CONFIRMADO";
            case EMBARQUE_IMEDIATO:
                return "EMBARQUE IMEDIATO";
            case EMBARQUE_PROXIMO:
                return "EMBARQUE PRÓXIMO";
            case POUSANDO:
                return "POUSANDO";
            case EM_SOLO:
                return "EM SOLO";
            default:
                return "DESCONHECIDO";
        }
    }

}