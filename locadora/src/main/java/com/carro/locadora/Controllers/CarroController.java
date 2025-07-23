package com.carro.locadora.Controllers;

import com.carro.locadora.domain.Carro;
import com.carro.locadora.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Carro carro){
        String msg = carroService.salvar(carro);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
