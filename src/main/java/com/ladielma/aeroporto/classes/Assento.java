package com.ladielma.aeroporto.classes;

public class Assento {
    private String idAssento;
    private boolean ocupado;
    private Classe classe;

    public enum Classe{
        ECONOMICA, EXECUTIVA, PRIMEIRA_CLASSE;
    }

    public Assento(String idAssento, boolean ocupado, Classe classe) {
        this.idAssento = idAssento;
        this.ocupado = ocupado;
        this.classe = classe;
    }

    public String getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(String idAssento) {
        this.idAssento = idAssento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
}
