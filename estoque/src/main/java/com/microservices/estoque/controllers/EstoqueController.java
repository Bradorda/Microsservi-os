package com.microservices.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.estoque.dtos.AtualizarEstoqueDTO;
import com.microservices.estoque.models.Estoque;
import com.microservices.estoque.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;
	
	@PostMapping("produtos/atualizar/quantidade")
	public ResponseEntity<Estoque> atualizarQuantidade
	(@RequestBody List<AtualizarEstoqueDTO> dtos){
		boolean isEstoqueUpdate = estoqueService.atualizarEstoque(dtos);
		if(isEstoqueUpdate) { 
			return new ResponseEntity<>(HttpStatus.OK);
			} else 
				return ResponseEntity.badRequest().build();
		}
		
	
}
