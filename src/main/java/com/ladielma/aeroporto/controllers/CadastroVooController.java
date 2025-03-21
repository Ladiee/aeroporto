package com.ladielma.aeroporto.controllers;

import java.io.IOException;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladielma.aeroporto.classes.Voo;


@RestController
@RequestMapping("/cadastroVoo")
public class CadastroVooController {

    @PostMapping
    public ResponseEntity<Voo> cadastrarVoo(@RequestBody Voo voo){
        return ResponseEntity.ok(voo); // 🔹 Retorna o voo cadastrado
    }
}



// @RestController
// @RequestMapping("/voos")
// public class CadastroVooController {



//     @PostMapping
//     public ResponseEntity<?> criarVoo(@RequestBody Voo voo) {
//         try {
//             System.out.println("Voo recebido: " + voo);
//             return ResponseEntity.ok().body(voo);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                 .body(Map.of("erro", "Erro interno ao processar o voo"));
//         }
//     }

    // @PostMapping
    // public ResponseEntity<String> criarVoo(@RequestBody Voo novoVoo) {
    //     System.out.println("Recebendo voo: " + novoVoo);
    //     return ResponseEntity.ok("Voo cadastrado com sucesso!");
    // }

    // @PostMapping("/voos")
    // public ResponseEntity<Voo> criarVoo(@RequestBody Voo voo) {

    //     System.out.println("Voo recebido: " + voo);
    //     return ResponseEntity.ok(voo);
    // }

//}
