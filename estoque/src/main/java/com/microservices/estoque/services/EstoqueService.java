package com.microservices.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.estoque.dtos.AtualizarEstoqueDTO;
import com.microservices.estoque.models.Estoque;
import com.microservices.estoque.models.Produto;
import com.microservices.estoque.repositories.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	public boolean atualizarEstoque(List<AtualizarEstoqueDTO> atualizarEstoqueDTOs) {		
		atualizarEstoqueDTOs.forEach(dto -> {
			Produto p = produtoService.buscarPorCodigoBarras(dto.getProduto().getCodigoBarras());
			
			if(p == null) {
				throw new RuntimeException("Não foi possivel atualizar estoque, produto não encontrado");
			}	
			Estoque estoque = estoqueRepository.findByProduto(p);
			estoque.setQuantidadeEstoque(estoque.getQuantidadeEstoque()+dto.getQuantidade());
			
			estoqueRepository.save(estoque);
			
		});
		return true;
	}
	
	public void adicionarNoEstoque(Produto produto, int quantidade) {
		estoqueRepository.save(Estoque.adcNoEstoque(produto, quantidade));
	}	
}
