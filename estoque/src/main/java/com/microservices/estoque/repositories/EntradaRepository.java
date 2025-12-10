package com.microservices.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.estoque.models.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada,Integer>{

}
