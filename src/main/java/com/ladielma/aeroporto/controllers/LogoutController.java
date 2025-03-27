package com.ladielma.aeroporto.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ladielma.aeroporto.classes.Cliente;
import com.ladielma.aeroporto.classes.Funcionario;

// import java.io.*;

@Controller
@RestController
@RequestMapping("/")
public class LogoutController {

    @PostMapping
    public RedirectView logout() {
        System.out.println("Aqui");

        if (!Funcionario.getFuncionarios().isEmpty()) {
            Funcionario.getFuncionarios().clear();
        }

        if (!Cliente.getClientes().isEmpty()) {
            String nome = Cliente.getClientes().get(0).getNome();
            String telefone = Cliente.getClientes().get(0).getTelefone();
            String email = Cliente.getClientes().get(0).getEmail();
            try {
                Path caminhoArquivo = Paths.get("src/main/resources/clientes.txt");
                List<String> linhas = Files.readAllLines(caminhoArquivo); // Lê todas as linhas do arquivo
                List<String> novasLinhas = new ArrayList<>(); // Lista para armazenar as linhas modificadas

                for (String line : linhas) {
                    String[] dados = line.split(", ");
                    if (dados[0].equals(email)) {
                        // Atualiza os dados do cliente
                        dados[1] = nome;
                        dados[2] = telefone;
                    }
                    // Adiciona a linha (modificada ou não) na nova lista
                    novasLinhas.add(String.join(", ", dados));
                }

                // Reescreve o arquivo com os dados atualizados
                Files.write(caminhoArquivo, novasLinhas, StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING);

            } catch (IOException e) {
                return new RedirectView("/login");
            }
            Cliente.getClientes().clear();
        }

        return new RedirectView("/");
    }
}
