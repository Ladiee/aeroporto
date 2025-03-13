package com.ladielma.aeroporto.classes;

public class Usuario extends Pessoa {
    private String nomeUsuario;
    private String senha;

    public Usuario(String nome, String email, String telefone, String nomeUsuario, String senha) {
        super(nome, email, telefone);
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getName() {
        return this.nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean logar(String nomeUsuario, String senha) {
        return this.nomeUsuario.equals(nomeUsuario) && this.senha.equals(senha);
    }
}