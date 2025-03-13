package com.ladielma.aeroporto.controllers;

import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.view.RedirectView;

import java.io.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String acesso(@RequestParam String email, @RequestParam String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[0].equals(email) && dados[7].equals(password)) {
                    return "Sucesso!";
                }
            }
        } catch (IOException e) {
            return "Erro ao acessar os dados!";
        }
        return "Erro ao acessar os dados!";
    }
}