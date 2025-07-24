package com.carro.locadora.repositories;

import com.carro.locadora.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByNome(String nome);

    List<Carro> findByMarca_Id(Long marcaId);

    @Query("FROM Carro car WHERE car.ano > :ano")
    List<Carro> findByAcimaAno(Integer ano);
}
