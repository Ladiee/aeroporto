package com.ladielma.aeroporto.classes;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Usuario extends Pessoa {
    private String nomeUsuario;
    private String senha;

    public Usuario(String nome, String email, String telefone, String nomeUsuario, String senha) {
        super(nome, email, telefone);
        this.nomeUsuario = nomeUsuario;
        this.senha = hashSenha(senha);
    }  

    public String getName() {
        return this.nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean logar(String nomeUsuario, String senha) {
        return this.nomeUsuario.equals(nomeUsuario) && verificarSenha(senha, this.senha);
    }

    // Gera o hash da senha
    private static String hashSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    // Verifica se a senha inserida corresponde ao hash armazenado
    private static boolean verificarSenha(String senha, String hash) {
        return BCrypt.checkpw(senha, hash);
    }

}