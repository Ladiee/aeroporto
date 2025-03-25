package com.ladielma.aeroporto.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladielma.aeroporto.classes.Voo;
import com.ladielma.aeroporto.classes.Voo.StatusVoo;

@RestController
@Controller
@RequestMapping("/homeFunc")
public class homeFuncController {
    @DeleteMapping("/homeFunc")
    public ResponseEntity<String> deletarVoo(@RequestParam("id") String id) {
        System.out.println("Tentando deletar voo com ID: " + id); // Log para verificar o ID recebido
        Iterator<Voo> iterator = Voo.getVoos().iterator();
        while (iterator.hasNext()) {
            Voo voo = iterator.next();
            System.out.println("Verificando voo: " + voo.getIdVoo()); // Log para verificar os IDs dos voos

            if (voo.getIdVoo().equals(id)) {
                iterator.remove();
                System.out.println("Voo deletado com sucesso!"); // Log para confirmar a exclusão
                return ResponseEntity.ok("Voo deletado com sucesso!");
            }
        }

        System.out.println("Voo não encontrado!"); // Log caso o voo não seja encontrado
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado!");
    }

    @PostMapping("/homeFunc/atualizarStatus")
    public ResponseEntity<Map<String, Object>> atualizarStatus(@RequestBody Map<String, String> request) {
    String id = request.get("id");
    String novoStatusStr = request.get("novoStatus");

    try {
        StatusVoo novoStatus = StatusVoo.valueOf(novoStatusStr); // Converte String para Enum

        for (Voo voo : Voo.getVoos()) {
            if (voo.getIdVoo().equals(id)) {
                voo.setStatusVoo(novoStatus); // Define o status como Enum

                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Status atualizado com sucesso!");

                return ResponseEntity.ok(response);
            }
        }
        // Se não encontrar o voo
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Voo não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    } catch (IllegalArgumentException e) {
        // Se a String não corresponder a um valor válido do Enum
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Status inválido!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}


}
