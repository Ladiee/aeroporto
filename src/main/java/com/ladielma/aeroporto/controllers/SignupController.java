package com.ladielma.aeroporto.controllers;

// import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileWriter;
import java.io.IOException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Controller
@RestController
@RequestMapping("/signup")
public class SignupController {

    @PostMapping
    public RedirectView salvarRegistro(@RequestParam String emailS,
            @RequestParam String nomeUsuario,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String dataDeNascimento,
            @RequestParam String sexo,
            @RequestParam String nacionalidade,
            @RequestParam String passwordS,
            @RequestParam String confirmPasswordS,
            RedirectAttributes redirectAttributes) {

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String nomeRegex = "^[A-Z][a-z]{2,}\\s[A-Z][a-z]{2,}$";
        String teleRegex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";
        String cpfRegex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        String passRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{6,}$";

        if (!validarEmail(emailRegex, emailS)) {
            redirectAttributes.addFlashAttribute("erro", "Email inválido! Exemplo: exemplo@gmail.com");
            return new RedirectView("/signup");
        }

        if (!validarNome(nomeRegex, nomeUsuario)) {
            redirectAttributes.addFlashAttribute("erro", "Nome inválido! Exemplo: Nome Sobrenome");
            return new RedirectView("/signup");
        }

        if (!validarTelefone(teleRegex, telefone)) {
            redirectAttributes.addFlashAttribute("erro", "Telefone inválido! Exemplo: (00) 00000-0000");
            return new RedirectView("/signup");
        }

        if (!validarCpf(cpfRegex, cpf)) {
            redirectAttributes.addFlashAttribute("erro", "CPF inválido! Exemplo: 000.000.000-00");
            return new RedirectView("/signup");
        }

        if (!validarSenha(passRegex, passwordS) ||
                !validarSenha(passRegex, confirmPasswordS)) {
            redirectAttributes.addFlashAttribute("erro",
                    "Senha inválida! A senha deve conter no mínimo 6 caracteres, uma letra maiúscula, um número e um caractere especial.");
            return new RedirectView("/signup");
        }

        if (!passwordS.equals(confirmPasswordS)) {
            redirectAttributes.addFlashAttribute("erro", "As senhas não coincidem!");
            return new RedirectView("/signup");
        }

        String dados = String.format("%s, %s, %s, %s, %s, %s, %s, %s%n",
                emailS, nomeUsuario, telefone, cpf,
                dataDeNascimento, sexo, nacionalidade, passwordS);

        try (FileWriter writer = new FileWriter("src/main/resources/clientes.txt",
                true)) {
            writer.write(dados);
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("erro", "As senhas não coincidem!");
            return new RedirectView("/signup");
        }

        return new RedirectView("/");
    }

    private boolean validarEmail(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean validarNome(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean validarTelefone(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean validarCpf(String regex, String input) {
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
