package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;

@Controller
@RestController
@RequestMapping("/signup")
public class SignupController {

    @PostMapping
    public String salvarRegistro(@RequestParam String emailS,
            @RequestParam String nomeUsuario,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String dataDeNascimento,
            @RequestParam String sexo,
            @RequestParam String nacionalidade,
            @RequestParam String passwordS) {

        String dados = String.format("%s, %s, %s, %s, %s, %s, %s, %s%n",
                emailS, nomeUsuario, telefone, cpf,
                dataDeNascimento, sexo, nacionalidade, passwordS);

        try (FileWriter writer = new FileWriter("src/main/resources/clientes.txt", true)) {
            writer.write(dados);
        } catch (IOException e) {
            return "Erro ao salvar os dados!";
        }

        return "Sucesso!";
    }
}
