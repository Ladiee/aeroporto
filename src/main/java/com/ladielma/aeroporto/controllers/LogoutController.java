package com.ladielma.aeroporto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ladielma.aeroporto.classes.Cliente;

// import java.io.*;

@Controller
@RestController
@RequestMapping("/")
public class LogoutController {

    @PostMapping
    public RedirectView logout() {
        System.out.println("Aqui");
        Cliente.getClientes().clear();
        return new RedirectView("/");
    }
}
