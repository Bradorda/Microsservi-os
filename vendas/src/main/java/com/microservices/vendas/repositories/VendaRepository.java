package com.microservices.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.vendas.models.Venda;

public interface VendaRepository extends JpaRepository<Venda,Integer>{

}
