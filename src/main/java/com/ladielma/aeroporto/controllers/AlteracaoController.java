package com.ladielma.aeroporto.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ladielma.aeroporto.classes.Cliente;

// import com.ladielma.aeroporto.classes.Cliente;

// import java.io.*;

@Controller
@RestController
@RequestMapping("/alterar-dados")
public class AlteracaoController {

    @PostMapping
    public RedirectView alterar(@RequestParam String nome, @RequestParam String telefone, @RequestParam String email,
            RedirectAttributes red) {
        System.out.println(nome);

        String nomeRegex = "^[A-Z][a-z]{2,}\\s[A-Z][a-z]{2,}$";
        String teleRegex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";

        if (!validarNome(nomeRegex, nome)) {
            red.addFlashAttribute("erro", "Nome inválido! Exemplo: Nome Sobrenome");
            return new RedirectView("/alterar-dados");
        }

        if (!validarTelefone(teleRegex, telefone)) {
            red.addFlashAttribute("erro", "Telefone inválido! Exemplo: (00) 00000-0000");
            return new RedirectView("/alterar-dados");
        }

        for (Cliente c : Cliente.getClientes()) {
            if (c.getEmail().equals(email)) {
                c.setNome(nome);
                c.setTelefone(telefone);
                break;
            }
        }

        return new RedirectView("/");
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

}
