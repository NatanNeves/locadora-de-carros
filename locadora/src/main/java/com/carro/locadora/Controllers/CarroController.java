package com.carro.locadora.Controllers;

import com.carro.locadora.domain.Carro;
import com.carro.locadora.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try {
            String msg = carroService.save(carro);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao salvar carro: " + e.toString());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id){
        try {
            String msg = carroService.update(carro, id);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar carro");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String msg = carroService.delete(id);
            return ResponseEntity.ok(msg);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar carro");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {
        return carroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listaCarros(){
        List<Carro> carros = carroService.findAll();
        return ResponseEntity.ok(carros);
    }
}
