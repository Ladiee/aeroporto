package com.ladielma.aeroporto.controllers;

import java.util.Iterator;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ladielma.aeroporto.classes.Voo;

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

}
