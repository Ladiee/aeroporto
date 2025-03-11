package com.ladielma.aeroporto.classes;

public class Aviao {
    private String modelo;
    private String fabricante;
    private int capacidade;
    private int qtdAssentos;
    private int qtdAssentosEconomicos;
    private int qtdAssentosExecutivos;
    private int qtdAssentosPrimeiraClasse;

    public Aviao(String modelo, String fabricante, int capacidade, int qtdAssentos, int qtdAssentosEconomicos, int qtdAssentosExecutivos, int qtdAssentosPrimeiraClasse) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
        this.qtdAssentos = qtdAssentos;
        this.qtdAssentosEconomicos = qtdAssentosEconomicos;
        this.qtdAssentosExecutivos = qtdAssentosExecutivos;
        this.qtdAssentosPrimeiraClasse = qtdAssentosPrimeiraClasse;
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

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
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

    
}
