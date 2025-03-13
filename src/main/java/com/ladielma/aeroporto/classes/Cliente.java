package com.ladielma.aeroporto.classes;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cliente extends Usuario {
    private String dataNascimento;
    private String cpf;
    private String nacionalidade;
    private Sexo sexo;
    private ArrayList<Reserva> viagens;
    private ArrayList<Cliente> clientes;
    private int pontos;

    public Cliente(String nome, String email, String telefone, String nomeUsuario, String senha, String dataNascimento,
            String cpf, String nacionalidade, Sexo sexo, int pontos) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.viagens = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pontos = pontos;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void mostrarHistorico() {
        // Implementação do histórico de reservas
    }

    public void alterarInformacoes() {
        // Implementação para alterar informações do cliente
    }
}
