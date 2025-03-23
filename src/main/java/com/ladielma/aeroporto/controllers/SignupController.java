package com.ladielma.aeroporto.controllers;

// import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedReader;
import java.io.FileReader;
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

        if (!verificarEmail(emailS)) {
            redirectAttributes.addFlashAttribute("erro", "Email inserido ja está sendo usado!");
            return new RedirectView("/signup");
        }

        if (!verificarNome(nomeUsuario)) {
            redirectAttributes.addFlashAttribute("erro", "Nome inserido ja está sendo usado!");
            return new RedirectView("/signup");
        }

        if (!verificarTel(telefone)) {
            redirectAttributes.addFlashAttribute("erro", "Telefone inserido ja está sendo usado!");
            return new RedirectView("/signup");
        }

        if (!verificarCpf(cpf)) {
            redirectAttributes.addFlashAttribute("erro", "CPF inserido ja está sendo usado!");
            return new RedirectView("/signup");
        }

        if (!verificarSenha(passwordS)) {
            redirectAttributes.addFlashAttribute("erro", "Senha inserido ja está sendo usado!");
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

        redirectAttributes.addFlashAttribute("sucesso",
                "Cadastro realizado com sucesso! Para acessar o site, realize o login!");
        return new RedirectView("/login");
    }

    private boolean verificarEmail(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[0].equals(email)) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private boolean verificarNome(String nome) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[1].equals(nome)) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private boolean verificarTel(String tel) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[2].equals(tel)) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private boolean verificarCpf(String cpf) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[3].equals(cpf)) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private boolean verificarSenha(String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/clientes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(", ");
                if (dados[7].equals(senha)) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
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
