package com.microservices.pessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.pessoas.models.Cliente;
import com.microservices.pessoas.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping("/create")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
		if(cliente == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(service.salvar(cliente));
		
	}
	
	@GetMapping("/{documento}")
	public ResponseEntity<Cliente> buscarPorDocumento(@PathVariable String documento){
		Cliente c = service.buscarPorDocumento(documento);
		if(c != null) return new ResponseEntity<>(c,HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
