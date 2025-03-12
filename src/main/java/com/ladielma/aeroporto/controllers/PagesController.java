package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ladielma.aeroporto.classes.Voo;

@Controller
public class PagesController {

    //Controle da home
    @GetMapping("/") 
    public String listarVoos(Model model) {
        model.addAttribute("voos", Voo.getVoos()); 

        return "home";
    }

    // Controle das páginas html para login e signup
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
