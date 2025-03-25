package com.ladielma.aeroporto.classes;

public class Viajante extends Pessoa {
    private String dataNascimento;
    private Sexo sexo;
    private String cpf;
    private String passaporte;
    private StatusViajante status;

    public Viajante(String nome, String email, String telefone, String dataNascimento, Sexo sexo, String cpf, String passaporte, StatusViajante status) {
        super(nome, email, telefone);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.status = status;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Viajante: " + super.getNome());
    }

    @Override
    public String getTipoPessoa() {
        return "Viajante";
    }
}