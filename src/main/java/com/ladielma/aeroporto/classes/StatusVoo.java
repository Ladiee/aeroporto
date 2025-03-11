package com.ladielma.aeroporto.classes;

public enum StatusVoo {
    ATRASADO, CANCELADO, CONFIRMADO, EMBARQUE_PROXIMO, EMBARQUE_IMEDIATO, POUSANDO, EM_SOLO;

    public static String getStatusVoo(StatusVoo status){
        switch (status) {
            case ATRASADO:
                return "ATRASADO";
            case CANCELADO:
                return "CANCELADO";
            case CONFIRMADO:
                return "CONFIRMADO";
            case EMBARQUE_IMEDIATO:
                return "EMBARQUE IMEDIATO";
            case EMBARQUE_PROXIMO:
                return "EMBARQUE PROXIMO";
            case POUSANDO:
                return "POUSANDO";
            case EM_SOLO:
                return "EM SOLO";
            default:
                return null;
        }
    }
}