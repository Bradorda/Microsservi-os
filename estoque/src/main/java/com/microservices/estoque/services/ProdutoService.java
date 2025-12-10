package com.microservices.estoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.estoque.models.Produto;
import com.microservices.estoque.repositories.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto salvar(Produto produto) {
		if(produto != null) {
			return repository.save(produto);
		} else
			throw new RuntimeException("Não foi possivel salvar o produto.");	
	}
	
	public Produto buscarPorId(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Produto buscarPorCodigoBarras(String codigo){
		return repository.findByCodigoBarras(codigo);
	}

	public void atualizarPrecoVenda(Produto produto, double custo) {
		Produto p = buscarPorCodigoBarras(produto.getCodigoBarras());
		
		if(p != null) {
			p.atualizarPrecoVenda(custo);
			produto.setProdutoId(p.getProdutoId());
			produto.setPrecoVenda(p.getPrecoVenda());
			produto.setCustoMedioUnitario(custo);
			repository.save(produto);
		} else
			throw new RuntimeException("Produto não encontrado.");
	}
	
}
