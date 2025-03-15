package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String nome;
    private String pis;
    private String dataNascimento;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario(String nome, String email, String telefone, String nomeUsuario, String senha, String pis, String dataNascimento) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.nome = nome;
        this.pis = pis;
        this.dataNascimento = dataNascimento;
        funcionarios.add(this);
    }

    public void cadastrarNovoVoo(String idVoo, String horario, Voo.Terminal terminal, String chegadaDestino, Companhia companhia, Aviao aviao) {
        // Implementação do cadastro de um novo voo
    }

    public void mudarSituacaoVoo(Voo voo) {
        // Implementação para mudar a situação de um voo
    }

    public void cancelarVoo(Voo voo) {
        // Implementação para cancelar um voo
    }
}
