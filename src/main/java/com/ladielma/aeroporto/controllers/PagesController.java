package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ladielma.aeroporto.AeroportoApplication;
import com.ladielma.aeroporto.classes.Aviao;
import com.ladielma.aeroporto.classes.Cliente;
import com.ladielma.aeroporto.classes.Companhia;
import com.ladielma.aeroporto.classes.Funcionario;
import com.ladielma.aeroporto.classes.Voo;

@Controller
public class PagesController {

    private final AeroportoApplication aeroportoApplication;

    PagesController(AeroportoApplication aeroportoApplication) {
        this.aeroportoApplication = aeroportoApplication;
    }

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
            model.addAttribute("clienteEmail", Cliente.getClientes().get(0).getEmail());
            model.addAttribute("clienteTelefone", Cliente.getClientes().get(0).getTelefone());
            // model.addAttribute("clientePontos",
            // Cliente.getClientes().get(0).getPontos());

        } else {
            model.addAttribute("clienteNome", null);
        }
        if (!Funcionario.getFuncionarios().isEmpty()) {
            model.addAttribute("funcionarioNome", Funcionario.getFuncionarios().get(0).getNome());
        } else {
            model.addAttribute("funcionarioNome", null);
        }
        return "home";
    }

    @GetMapping("/cadastroVoo")
    public String cadastroVoo(Model model) {
        model.addAttribute("avioes", Aviao.getAvioes());
        model.addAttribute("companhias", Companhia.getCompanhias());
        model.addAttribute("statusList", Voo.StatusVoo.values());
        model.addAttribute("funcionarios", !Funcionario.getFuncionarios().isEmpty());

        return "cadastroVoo";
    }

    @GetMapping("/homeFunc")
    public String funcionarioHome(Model model) {
        model.addAttribute("statusList", Voo.StatusVoo.values());
        model.addAttribute("voos", Voo.getVoos());
        model.addAttribute("companhias", Companhia.getCompanhias());
        boolean func = !Funcionario.getFuncionarios().isEmpty();
        if (func) {
            model.addAttribute("funcionarioNome", Funcionario.getFuncionarios().get(0).getNome());
            model.addAttribute("funcionarioEmail", Funcionario.getFuncionarios().get(0).getEmail());
        } else {
            model.addAttribute("funcionarioNome", null);
        }
        model.addAttribute("funcionario", func);

        return "homeFunc";
    }

    @GetMapping("/alterar-dados")
    public String teste(Model model) {
        boolean clienteLogado = !Cliente.getClientes().isEmpty();
        model.addAttribute("clienteLogado", clienteLogado);
        if (clienteLogado) {
            System.out.println("clienteNome" + Cliente.getClientes().get(0).getNome());
            model.addAttribute("clienteNome", Cliente.getClientes().get(0).getNome());
            model.addAttribute("clienteEmail", Cliente.getClientes().get(0).getEmail());
            model.addAttribute("clienteTelefone", Cliente.getClientes().get(0).getTelefone());
            // model.addAttribute("clientePontos",
            // Cliente.getClientes().get(0).getPontos());

        } else {
            model.addAttribute("clienteNome", null);
        }
        if (!Funcionario.getFuncionarios().isEmpty()) {
            model.addAttribute("funcionarioNome", Funcionario.getFuncionarios().get(0).getNome());
        } else {
            model.addAttribute("funcionarioNome", null);
        }
        model.addAttribute("funcionario", !Funcionario.getFuncionarios().isEmpty());
        return "alterar-dados";
    }

    @GetMapping("/redefinir-senha")
    public String redefinirSenha(Model model) {
        boolean clienteLogado = !Cliente.getClientes().isEmpty();
        model.addAttribute("clienteLogado", clienteLogado);
        return "redefinir-senha";
    }

    // Controle das páginas html para login e signup
    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("Quantidade de clientes: " + Cliente.getClientes().size());
        System.out.println("Quantidade de func: " + Funcionario.getFuncionarios().size());
        System.out.println(Funcionario.getFuncionarios().isEmpty());
        System.out.println(Cliente.getClientes().isEmpty());
        boolean funcLogado = !Funcionario.getFuncionarios().isEmpty();
        boolean clienteLogado = !(Cliente.getClientes().isEmpty());
        model.addAttribute("funcLogado", funcLogado);
        model.addAttribute("clienteLogado", clienteLogado);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        System.out.println("Quantidade de clientes: " + Cliente.getClientes().size());
        System.out.println(Funcionario.getFuncionarios().isEmpty());
        System.out.println(Cliente.getClientes().isEmpty());
        boolean funcLogado = !Funcionario.getFuncionarios().isEmpty();
        boolean clienteLogado = !Cliente.getClientes().isEmpty();
        model.addAttribute("funcLogado", funcLogado);
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

    @GetMapping("/voos")
    public String voos() {
        return "voos";
    }

    @GetMapping("/sobre_passagem")
    public String sobrePassagem() {
        return "sobre_passagem";
    }
}
