package com.ladielma.aeroporto.controllers;

import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ladielma.aeroporto.classes.Voo;

@Controller
@RequestMapping("/homeFunc")
public class homeFuncController {
    @DeleteMapping("/homeFunc")
    public ResponseEntity<String> deletarVoo(@RequestBody Map<String, String> request) {
        String id = request.get("id"); // Pegando o ID do JSON enviado pelo fetch

        Iterator<Voo> iterator = Voo.getVoos().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIdVoo().equals(id)) {
                iterator.remove();
                return ResponseEntity.ok("Voo deletado com sucesso!");
            }
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado!");
    }

}
