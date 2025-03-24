package com.ladielma.aeroporto.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ladielma.aeroporto.classes.Cliente;
import com.ladielma.aeroporto.classes.Funcionario;

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
                if (dados.length == 9) {
                    if (dados[0].equals(email) && dados[7].equals(password)) {
                        Funcionario func = new Funcionario(dados[1], dados[0], dados[2], dados[1], dados[7], dados[4],
                                dados[3]);
                        func.adicionarFuncionario(func);
                        red.addFlashAttribute("sucesso",
                                "Login realizado com sucesso!");
                        return new RedirectView("/");

                    }
                } else if (dados[0].equals(email) && dados[7].equals(password)) {

                    Cliente cliente = new Cliente(dados[1], dados[0], dados[2], dados[1], dados[7], dados[4], dados[3],
                            dados[6], null, 0);
                    cliente.adicionarCliente(cliente);
                    red.addFlashAttribute("sucesso",
                            "Login realizado com sucesso!");
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