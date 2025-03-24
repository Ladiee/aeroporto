package com.ladielma.aeroporto.classes;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String nome;
    private String pis;
    private String dataNascimento;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    static{
        Funcionario funcionario1 = new Funcionario("João Vasconcelos", "joao.vasco@gmail.com", "91982674567", "joao.vasco", "123456", "123456789", "12/12/1990");

        Funcionario funcionario2 = new Funcionario("Maria Silva", "silva.mari@gmail.com", "91987691380", "silva.maria", "234567", "987654321", "10/10/1995");
    }

    public Funcionario(String nome, String email, String telefone, String nomeUsuario, String senha, String pis, String dataNascimento) {
        super(nome, email, telefone, nomeUsuario, senha);
        this.nome = nome;
        this.pis = pis;
        this.dataNascimento = dataNascimento;
        funcionarios.add(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario() {
        funcionarios.clear();
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
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
