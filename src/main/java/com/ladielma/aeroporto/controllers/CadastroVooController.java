package com.ladielma.aeroporto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladielma.aeroporto.classes.Voo;


@RestController
@RequestMapping("/cadastroVoo")
public class CadastroVooController {

    @PostMapping
    public ResponseEntity<Voo> cadastrarVoo(@RequestBody Voo voo){
        return ResponseEntity.ok(voo); // 🔹 Retorna o voo cadastrado
    }

    @PostMapping("/cadastroVoo/atualizarStatus")
    public String atualizarStatus(@RequestParam("id") String id, @RequestParam("novoStatus") String novoStatus) {
        try {
            Voo.StatusVoo statusEnum = Voo.StatusVoo.valueOf(novoStatus); // Converte a string para o Enum
    
            for (Voo voo : Voo.getVoos()) {
                if (voo.getIdVoo().equals(id)) {
                    voo.setStatusVoo(statusEnum);
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            // Lida com o caso de um status inválido
            System.out.println("Status inválido: " + novoStatus);
            return "redirect:/erro";
        }
    
        return "redirect:/homeFunc"; // Redireciona para a página principal
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
