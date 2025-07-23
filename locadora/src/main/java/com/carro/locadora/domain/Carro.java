package com.carro.locadora.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id;

    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;

    // Construtor padrão (necessário pro JPA)
    public Carro() {}

    // Construtor com argumentos (opcional, útil pra instanciar direto)
    public Carro(String nome, String marca, Integer ano, String modelo) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
