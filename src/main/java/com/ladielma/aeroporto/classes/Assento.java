package com.ladielma.aeroporto.classes;

public class Assento {
    private int idAssento;
    private boolean ocupado;
    private Classe classe;

    public enum Classe{
        ECONOMICA, EXECUTIVA, PRIMEIRA_CLASSE;
    }

    public Assento(int idAssento) {
        this.idAssento = idAssento;
        this.ocupado = false;
    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}
