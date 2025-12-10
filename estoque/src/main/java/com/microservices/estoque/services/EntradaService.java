package com.microservices.estoque.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.estoque.models.Entrada;
import com.microservices.estoque.models.Produto;
import com.microservices.estoque.repositories.EntradaRepository;
import com.microservices.estoque.clients.PessoasClient;
import com.microservices.estoque.dtos.AtualizarEstoqueDTO;
import com.microservices.estoque.dtos.FornecedorDTO;


import jakarta.transaction.Transactional;

@Service
public class EntradaService {
	
	@Autowired
	private PessoasClient pessoa;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Transactional
	public Entrada realizarEntrada(Entrada entrada) {
		
		List<AtualizarEstoqueDTO> atualizarEstoqueProdutos = new ArrayList<>();
		
		FornecedorDTO fornecedor = pessoa.buscarCliente(entrada.getFornecedor());	
		if(fornecedor == null) {
			throw new RuntimeException("Fornecedor não existe no serviço de Pessoas");
		}	
		entrada.setFornecedor(fornecedor.getDocumento());
		
		entrada.getItens().forEach(item ->{	
			Produto produto = produtoService.buscarPorCodigoBarras(item.getCodigoBarras());
			if(produto == null) {
				throw new RuntimeException("Produto não existe no serviço Estoque");
			}
			produtoService.atualizarPrecoVenda(produto, item.getValorUnitario());
			item.setProdutoId(produto.getProdutoId());	
			atualizarEstoqueProdutos.add(
					new AtualizarEstoqueDTO(produto,
							item.getQuantidade())
					);
		});
		
	    entrada.getItens().forEach(item -> {
	        item.setEntrada(entrada);
	    });
	    
	    entrada.setValorTotal(entrada.calcularValorTotal());
	    
	    Entrada entradaSalva = entradaRepository.save(entrada);
	    
	    estoqueService.atualizarEstoque(atualizarEstoqueProdutos);
	    
	    return entradaSalva;
	}

}
