package com.microservices.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.vendas.models.Venda;
import com.microservices.vendas.services.VendaService;

@RequestMapping("/venda")
@RestController
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@PostMapping
	public ResponseEntity<Venda>  realizarVenda(@RequestBody Venda venda){
		if(venda != null) {
			Venda vendaSalva = service.realizarVenda(venda);
			return ResponseEntity.ok(vendaSalva);
		} else
			return ResponseEntity.badRequest().build();
	}
	
	@GetMapping
	public List<Venda>vendas(){
		return service.buscarVendas();
	}

}
