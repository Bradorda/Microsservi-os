package com.microservices.estoque.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.estoque.dtos.FornecedorDTO;

@FeignClient(name = "pessoas-ms", url = "http://localhost:8084")
public interface PessoasClient {
	
	@GetMapping("/clientes/{documento}")
	FornecedorDTO buscarCliente(@PathVariable String documento);

}
