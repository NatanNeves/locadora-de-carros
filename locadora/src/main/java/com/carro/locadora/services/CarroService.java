package com.carro.locadora.services;

import com.carro.locadora.domain.Carro;
import com.carro.locadora.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String salvar(Carro carro){
        carroRepository.save(carro);
        return "carro salvo com sucesso!";
    }
}
