package com.microservices.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.estoque.models.EntradaItem;

public interface EntradaItemRepository extends JpaRepository<EntradaItem,Integer>{

}
