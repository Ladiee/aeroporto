package com.ladielma.aeroporto.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

// import com.ladielma.aeroporto.classes.Cliente;

// import java.io.*;

@Controller
@RestController
@RequestMapping("/redefinir-senha")
public class RedefinirSenhaController {

    @PostMapping
    public RedirectView redefinirSenha(@RequestParam String email, @RequestParam String password,
            @RequestParam String confirmPassword,
            RedirectAttributes red) {
        System.out.println(email);

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String passRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{6,}$";

        if (!validarEmail(emailRegex, email)) {
            red.addFlashAttribute("erro", "Email inválido! Exemplo: exemplo@gmail.com");
            return new RedirectView("/redefinir-senha");
        }

        if (!validarSenha(passRegex, password)) {
            red.addFlashAttribute("erro",
                    "Senha inválida! A senha deve conter no mínimo 6 caracteres, uma letra maiúscula, um número e um caractere especial.");
            return new RedirectView("/redefinir-senha");
        }

        if (!password.equals(confirmPassword)) {
            red.addFlashAttribute("erro", "As senhas não coincidem!");
            return new RedirectView("/redefinir-senha");
        }

        try {
            Path caminhoArquivo = Paths.get("src/main/resources/clientes.txt");
            List<String> linhas = Files.readAllLines(caminhoArquivo); // Lê todas as linhas do arquivo
            List<String> novasLinhas = new ArrayList<>(); // Lista para armazenar as linhas modificadas

            for (String line : linhas) {
                String[] dados = line.split(", ");
                if (dados[0].equals(email)) {
                    // Atualiza os dados do cliente
                    dados[7] = password;
                }
                // Adiciona a linha (modificada ou não) na nova lista
                novasLinhas.add(String.join(", ", dados));
            }

            // Reescreve o arquivo com os dados atualizados
            Files.write(caminhoArquivo, novasLinhas, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            red.addFlashAttribute("erro", "Erro ao tentar acessar a conta");
            return new RedirectView("/login");
        }

        return new RedirectView("/");
    }

    private boolean validarEmail(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean validarSenha(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
