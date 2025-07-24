package com.carro.locadora.services;

import com.carro.locadora.domain.Carro;
import com.carro.locadora.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro){
        this.carroRepository.save(carro);
        return "carro salvo com sucesso!";
    }

    public String update(Carro carro, Long id){
        carro.setId(id);
        this.carroRepository.save(carro);
        return "carro atualizado com sucesso";
    }

    public String delete(Long id){
        this.carroRepository.deleteById(id);
        return "carro deletado com sucesso";
    }

    public Optional<Carro> findById (Long id){

        Optional<Carro> carro = this.carroRepository.findById(id);
        return carro;
    }

    public List<Carro> findAll(){
        return this.carroRepository.findAll();
    }
}
