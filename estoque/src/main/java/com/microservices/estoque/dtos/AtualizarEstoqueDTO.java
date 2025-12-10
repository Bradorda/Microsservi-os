package com.microservices.estoque.dtos;

import com.microservices.estoque.models.Produto;

public class AtualizarEstoqueDTO {
	
    private Produto produto;
    private int quantidade;
    
	public AtualizarEstoqueDTO(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProdutoDTO(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}

