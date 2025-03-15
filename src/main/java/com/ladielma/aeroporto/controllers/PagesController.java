package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ladielma.aeroporto.classes.Aviao;
import com.ladielma.aeroporto.classes.Cliente;
import com.ladielma.aeroporto.classes.Companhia;
import com.ladielma.aeroporto.classes.Sexo;
import com.ladielma.aeroporto.classes.Voo;
import com.ladielma.aeroporto.classes.Voo.Terminal;

@Controller
public class PagesController {

    // Controle da home
    @GetMapping("/")
    public String listarVoos(Model model) {
        System.out.println("Quantidade de saidas voos: " + Voo.getSaidas().size());
        System.out.println("Quantidade de entradas voos: " + Voo.getChegadas().size());
        model.addAttribute("chegadas", Voo.getChegadas());
        model.addAttribute("saidas", Voo.getSaidas());
        return "home";
    }

    @GetMapping("/teste")
    public String teste() {

        return "teste";
    }

    // Controle das páginas html para login e signup
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String nome, @RequestParam String emailS, @RequestParam String telefone,
            @RequestParam String nomeUsuario, @RequestParam String passwordS, @RequestParam String dataNascimento,
            @RequestParam String cpf, @RequestParam String nacionalidade, @RequestParam String sexo) {
        // Implementação do cadastro de cliente

        Cliente cliente = new Cliente(nome, emailS, telefone, nomeUsuario, passwordS, dataNascimento, cpf,
                nacionalidade,
                Sexo.valueOf(sexo), 0);

        salvarEmArquivo(cliente);
        return "redirect:/teste";
    }

    private void salvarEmArquivo(Cliente cli) {
        String caminhoArquivo = "clientes.txt"; // Caminho do arquivo

        try {
            File arquivo = new File(caminhoArquivo);
            if (!arquivo.exists()) {
                arquivo.createNewFile(); // Cria o arquivo caso não exista
            }

            try (FileWriter writer = new FileWriter(arquivo, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                bufferedWriter.write(cli.getNome() + ", " +
                        cli.getEmail() + ", " +
                        cli.getCpf() + ", " +
                        cli.getSexo() + ", " +
                        cli.getDataNascimento() + ", " +
                        cli.getTelefone() + "\n");

                bufferedWriter.flush(); // Garante que os dados sejam escritos

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
