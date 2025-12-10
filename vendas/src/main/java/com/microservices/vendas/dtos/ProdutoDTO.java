package com.microservices.vendas.dtos;

import java.util.Objects;

public class ProdutoDTO {
	
	private String codigoBarras;
	private String nomeProduto;
	private double precoVenda;
	
	public ProdutoDTO(int id, String codigoBarras, String nomeProduto,
			double precoVenda) {
		super();
		this.codigoBarras = codigoBarras;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoBarras, nomeProduto, precoVenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(codigoBarras, other.codigoBarras)
				&& (nomeProduto) == (other.nomeProduto)
				&& Double.doubleToLongBits(precoVenda) == Double.doubleToLongBits(other.precoVenda);
	}

	@Override
	public String toString() {
		return "ProdutoDTO [id=" + ", codigoBarras=" + codigoBarras + ", custo_unitario=" + nomeProduto
				+ ", preco_venda=" + precoVenda + "]";
	}

}
