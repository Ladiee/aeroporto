package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Voo {
    private String idVoo;
    private String horario;
    private Terminal terminal;
    private String chegadaDestino;
    private Companhia companhia;
    private StatusVoo statusVoo;
    private Aviao aviao;
    private static ArrayList<Voo> voos = new ArrayList<Voo>();
    private Assento[] assentos;

    public enum Terminal{
        A, B, C;
    }

    public Voo(String idVoo, String horario, Terminal terminal, String chegadaDestino, Companhia companhia, StatusVoo status, Aviao aviao, Assento[] assentos) {
        this.idVoo = idVoo;
        this.horario = horario;
        this.terminal = terminal;
        this.chegadaDestino = chegadaDestino;
        this.companhia = companhia;
        this.statusVoo = status;
        this.aviao = aviao;
        this.assentos = assentos;
        voos.add(this);
    }

    public void setIdVoo(String idVoo) {
        this.idVoo = idVoo;
    }

    public String getIdVoo() {
        return idVoo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
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
