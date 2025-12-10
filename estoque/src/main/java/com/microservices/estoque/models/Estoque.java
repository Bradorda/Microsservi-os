package com.microservices.estoque.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estoque_id")
	private int estoqueId;
	
	@OneToOne()
	@JoinColumn(name = "produto_id", unique = true, nullable = false)
	private Produto produto;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private int quantidadeEstoque;

	public Estoque() {
		super();
	}
	
	public static Estoque adcNoEstoque(Produto produto, int quantidade) {
		Estoque e = new Estoque();		
		e.setProduto(produto);
		e.setQuantidadeEstoque(quantidade);	
		return e;
		
	}

	public Estoque(int estoqueId, Produto produto, int quantidadeEstoque) {
		super();
		this.estoqueId = estoqueId;
		this.produto = produto;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getEstoqueId() {
		return estoqueId;
	}

	public void setEstoqueId(int estoqueId) {
		this.estoqueId = estoqueId;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estoqueId, produto, quantidadeEstoque);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return estoqueId == other.estoqueId && Objects.equals(produto, other.produto)
				&& quantidadeEstoque == other.quantidadeEstoque;
	}

	@Override
	public String toString() {
		return "Estoque [estoqueId=" + estoqueId + ", produto=" + produto + ", quantidadeEstoque=" + quantidadeEstoque
				+ "]";
	}

}
