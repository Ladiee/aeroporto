package com.ladielma.aeroporto.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ladielma.aeroporto.classes.Cliente;
import com.ladielma.aeroporto.classes.Comprador;
// import com.ladielma.aeroporto.classes.Funcionario;
import com.ladielma.aeroporto.classes.Reserva;
import com.ladielma.aeroporto.classes.StatusViajante;
// import com.ladielma.aeroporto.classes.Usuario;

@RestController
@RequestMapping("/sobre_passagem")
public class SobrePassagemController {

    @PostMapping
    public RedirectView passagem(@RequestParam("idVoo") String idVoo,
            @RequestParam("horario") String horario,
            @RequestParam("origem") String origem,
            RedirectAttributes red) {

        // Adicionando os parâmetros na URL
        for (Cliente c : Cliente.getClientes()) {
            c.adicionarReserva(new Reserva("0001", idVoo, StatusViajante.CONFIRMADO,
                    new Comprador(c.getNome(), c.getEmail(), c.getTelefone(), "000"), null, null));
        }
        red.addFlashAttribute("sucesso", "Passagem comprada com sucesso!");
        return new RedirectView("/");
    }
}
