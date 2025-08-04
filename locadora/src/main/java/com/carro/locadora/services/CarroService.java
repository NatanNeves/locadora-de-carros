package com.carro.locadora.services;

import com.carro.locadora.domain.Carro;

import com.carro.locadora.repositories.CarroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro) {
        carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    public String update(Carro carro, Long id) {
        Carro carroExistente = carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));

        carroExistente.setNome(carro.getNome());
        carroExistente.setAno(carro.getAno());
        carroExistente.setMarca(carro.getMarca());
        carroExistente.setModelo(carro.getModelo());

        carroRepository.save(carroExistente);
        return "Carro atualizado com sucesso!";
    }

    public String delete(Long id) {
        carroRepository.deleteById(id);
        return "Carro deletado com sucesso!";
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }
}
