package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Aviao implements Exibivel {
    private String modelo;
    private String fabricante;
    private int qtdAssentos;
    private int qtdAssentosEconomicos;
    private int qtdAssentosExecutivos;
    private int qtdAssentosPrimeiraClasse;
    private static ArrayList<Aviao> avioes = new ArrayList<>();

    public Aviao(String modelo, String fabricante, int qtdAssentos, int qtdAssentosEconomicos, int qtdAssentosExecutivos, int qtdAssentosPrimeiraClasse) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.qtdAssentos = qtdAssentos;
        this.qtdAssentosEconomicos = qtdAssentosEconomicos;
        this.qtdAssentosExecutivos = qtdAssentosExecutivos;
        this.qtdAssentosPrimeiraClasse = qtdAssentosPrimeiraClasse;
        if (aviaoExiste(modelo) == false){
            avioes.add(this);
        }
    }

    private boolean aviaoExiste(String nomeModelo){
        for (Aviao aviao : avioes) {
            if (nomeModelo.equals(aviao.modelo)){
                return true;
            } 
        }
        return false; 
    }
    
    @Override
    public void exibirDados() {
        System.out.println("Avião: " + modelo + " | Companhia: " + fabricante);
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }

    public int getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentosEconomicos(int qtdAssentosEconomicos) {
        this.qtdAssentosEconomicos = qtdAssentosEconomicos;
    }

    public int getQtdAssentosEconomicos() {
        return qtdAssentosEconomicos;
    }

    public void setQtdAssentosExecutivos(int qtdAssentosExecutivos) {
        this.qtdAssentosExecutivos = qtdAssentosExecutivos;
    }

    public int getQtdAssentosExecutivos() {
        return qtdAssentosExecutivos;
    }

    public void setQtdAssentosPrimeiraClasse(int qtdAssentosPrimeiraClasse) {
        this.qtdAssentosPrimeiraClasse = qtdAssentosPrimeiraClasse;
    }

    public int getQtdAssentosPrimeiraClasse() {
        return qtdAssentosPrimeiraClasse;
    }

    public static ArrayList<Aviao> getAvioes(){
        return avioes;
    }


}
