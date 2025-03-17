package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ladielma.aeroporto.classes.Voo;
import com.ladielma.aeroporto.classes.Cliente;

@Controller
public class PagesController {

    // Controle da home
    @GetMapping("/")
    public String listarVoos(Model model) {
        System.out.println("Quantidade de saidas voos: " + Voo.getSaidas().size());
        System.out.println("Quantidade de entradas voos: " + Voo.getChegadas().size());
        System.out.println("Quantidade de clientes: " + Cliente.getClientes().size());

        model.addAttribute("chegadas", Voo.getChegadas());
        model.addAttribute("saidas", Voo.getSaidas());
        if (!Cliente.getClientes().isEmpty()) {
            System.out.println("clienteNome" + Cliente.getClientes().get(0).getNome());
            model.addAttribute("clienteNome", Cliente.getClientes().get(0).getNome());
        } else {
            model.addAttribute("clienteNome", null);
        }
        return "home";
    }

    @GetMapping("/teste")
    public String teste() {

        return "teste";
    }

    // Controle das páginas html para login e signup
    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("Quantidade de clientes: " + Cliente.getClientes().size());
        boolean clienteLogado = !Cliente.getClientes().isEmpty();
        model.addAttribute("clienteLogado", clienteLogado);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        System.out.println("Quantidade de clientes: " + Cliente.getClientes().size());
        boolean clienteLogado = !Cliente.getClientes().isEmpty();
        model.addAttribute("clienteLogado", clienteLogado);
        return "signup";
    }

    @GetMapping("/pagamento")
    public String pagamento() {
        return "pagamento";
    }

    @GetMapping("/assentos")
    public String assentos() {
        return "assentos";
    }
}
