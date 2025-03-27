package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private String dataNascimento;
    private String cpf;
    private String nacionalidade;
    private String sexo;
    private ArrayList<Reserva> viagens;
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private int pontos;

    public Cliente(String nome, String email, String telefone, String nomeUsuario, String senha, String dataNascimento,
            String cpf, String nacionalidade, String sexo, int pontos) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
        this.viagens = new ArrayList<>();
        this.pontos = pontos;
    }

    public ArrayList<Reserva> getViagens() {
        return viagens;
    }

    public void adicionarReserva(Reserva reserva) {
        viagens.add(reserva);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
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

    public String getSexo() {
        return this.sexo;
    }

    public int getPontos() {
        return this.pontos;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void mostrarHistorico() {
        // Implementação do histórico de reservas
    }

    public void alterarInformacoes() {
        // Implementação para alterar informações do cliente
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + super.getNome());
    }

    @Override
    public String getTipoPessoa() {
        return "Cliente";
    }
}
