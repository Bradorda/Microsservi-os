package com.microservices.pessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.pessoas.models.Cliente;
import com.microservices.pessoas.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {		
		Cliente c = buscarPorDocumento(cliente.getDocumento());
	
		if(c != null) {
			throw new RuntimeException("Já existe um cliente cadastrado.");
		}		
		return repository.save(cliente);		
	}
	
	
	public Cliente buscarPorDocumento(String documento) {
		Cliente cliente = repository.findByDocumento(documento);
		return cliente;
	}

}
