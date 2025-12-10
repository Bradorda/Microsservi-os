package com.microservices.pessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.pessoas.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByDocumento(String documento);

}
