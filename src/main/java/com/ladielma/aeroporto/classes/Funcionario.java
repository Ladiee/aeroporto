package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String nome;
    private String pix;
    private String dataNascimento;
    private ArrayList<Funcionario> funcionarios;

    public Funcionario(String nome, String email, String telefone, String nomeUsuario, String senha, String pix, String dataNascimento) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.nome = nome;
        this.pix = pix;
        this.dataNascimento = dataNascimento;
        this.funcionarios = new ArrayList<>();
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
