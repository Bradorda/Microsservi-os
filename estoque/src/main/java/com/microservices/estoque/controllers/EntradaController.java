package com.microservices.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.estoque.models.Entrada;
import com.microservices.estoque.services.EntradaService;

@RestController
@RequestMapping("/entrada")
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Entrada> salvar(@RequestBody Entrada entrada){
		Entrada e = entradaService.realizarEntrada(entrada);
		if(e != null) return ResponseEntity.ok(e);
		else return ResponseEntity.badRequest().build();
		
	}
	

}
