package com.microservices.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.estoque.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Produto findByCodigoBarras(String codigoBarras);
	
}
