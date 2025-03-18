package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

// import com.ladielma.aeroporto.classes.Cliente;

// import java.io.*;

@Controller
@RestController
@RequestMapping("/alterar-dados")
public class AlteracaoController {

    @PostMapping
    public RedirectView alterar(@RequestParam String nome, @RequestParam String telefone, @RequestParam String email) {
        System.out.println(nome);
        return new RedirectView("/");
    }

}
