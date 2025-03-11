package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private String dataNascimento;
    private String cpf;
    private String nacionalidade;
    private Sexo sexo;
    private ArrayList<Reserva> viagens;
    private ArrayList<Cliente> clientes;
    private int pontos;

    public Cliente(String nome, String email, String telefone, String nomeUsuario, String senha, String dataNascimento, String cpf, String nacionalidade, Sexo sexo, int pontos) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.viagens = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pontos = pontos;
    }

    public void mostrarHistorico() {
        // Implementação do histórico de reservas
    }

    public void alterarInformacoes() {
        // Implementação para alterar informações do cliente
    }
}
