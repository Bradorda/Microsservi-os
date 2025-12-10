package com.microservices.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.estoque.models.Produto;
import com.microservices.estoque.services.EstoqueService;
import com.microservices.estoque.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
		Produto produtoSalvo = produtoService.salvar(produto);
		if(produtoSalvo != null) {
			estoqueService.adicionarNoEstoque(produtoSalvo, 0);
			return new ResponseEntity<>(produtoSalvo,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping("/{produto}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable String produto){
		Produto p = produtoService.buscarPorCodigoBarras(produto);
		if(p != null) return ResponseEntity.ok(p);
		else return ResponseEntity.badRequest().build();
		
	}

}
