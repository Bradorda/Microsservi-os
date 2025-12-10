package com.microservices.vendas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.vendas.dtos.ClienteDTO;

@FeignClient(name = "pessoas-ms", url = "http://localhost:8084/")
public interface PessoasClient {
	
	@GetMapping("/clientes/{documento}")
	ClienteDTO buscarCliente(@PathVariable String documento);

}
