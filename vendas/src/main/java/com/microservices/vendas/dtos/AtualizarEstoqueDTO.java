package com.microservices.vendas.dtos;

public class AtualizarEstoqueDTO {
	
    private ProdutoDTO produto;
    private int quantidade;
    
	public AtualizarEstoqueDTO(ProdutoDTO produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProdutoDTO(ProdutoDTO produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
