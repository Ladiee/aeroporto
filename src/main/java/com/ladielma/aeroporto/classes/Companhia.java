package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    private String pais;
    private String contato;
    private static ArrayList<Companhia> companhias = new ArrayList<Companhia>();

    public Companhia(String nome, String pais, String contato) {
        this.nome = nome;
        this.pais = pais;
        this.contato = contato;
        if (companhiaExiste(nome) == false){
            companhias.add(this);
        }
    }

    private boolean companhiaExiste(String nome){
        for (Companhia companhia : companhias) {
            if (nome.equals(companhia.nome)){
                return true;
            } 
        }
        return false; 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato() {
        return contato;
    }

    public static ArrayList<Companhia> getCompanhias() {
        return companhias;
    }
    
}
