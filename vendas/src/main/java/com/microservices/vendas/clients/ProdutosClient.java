package com.microservices.vendas.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.vendas.dtos.AtualizarEstoqueDTO;
import com.microservices.vendas.dtos.ProdutoDTO;

@FeignClient(name = "estoque-ms", url = "http://localhost:8083")
public interface ProdutosClient {
	
	@GetMapping("/produtos/{codigoBarras}")
	ProdutoDTO buscarProduto(@PathVariable String codigoBarras);
	
	@PostMapping("/estoque/produtos/atualizar/quantidade")
	ProdutoDTO atualizarQuantidade(@RequestBody List<AtualizarEstoqueDTO> vendaItem);

}
