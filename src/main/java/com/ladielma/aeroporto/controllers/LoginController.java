package com.ladielma.aeroporto.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public RedirectView acesso(@RequestParam String email, @RequestParam String password, RedirectAttributes red) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[0].equals(email) && dados[7].equals(password)) {
                    return new RedirectView("/");
                }
            }
        } catch (IOException e) {
            red.addFlashAttribute("erro", "Erro ao tentar acessar a conta");
            return new RedirectView("/login");
        }
        red.addFlashAttribute("erro", "Email ou senha incorretos");
        return new RedirectView("/login");
    }
}