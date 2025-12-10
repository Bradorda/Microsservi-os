package com.microservices.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.estoque.models.Estoque;
import com.microservices.estoque.models.Produto;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	
	Estoque findByProduto(Produto produto);

}
