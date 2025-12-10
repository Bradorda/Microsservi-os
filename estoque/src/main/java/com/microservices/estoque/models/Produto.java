package com.microservices.estoque.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private int produtoId;
	
	@Column(name = "codigo_barras", nullable = false, unique = true)
	private String codigoBarras;
	
	@Column(name = "nome_produto", unique = true, nullable = false)
	private String nomeProduto;
	
	@Column(name = "aliquota_icms", nullable = false, length = 2)
	private double aliquotaIcms;
	
	@Column(name = "margem_lucro", nullable = false, length = 2)
	private double margemLucro;
	
	@Column(name = "custo_medio_unitario", nullable = false)
	private double custoMedioUnitario;
	
	@Column(name = "preco_venda", nullable = false)
	private double precoVenda;
	
	public Produto() {
		super();
	}
	
	public Produto(int produtoId, String codigoBarras, String nomeProduto, double aliquotaIcms, double margemLucro,
			double custoMedioUnitario, double precoVenda) {
		super();
		this.produtoId = produtoId;
		this.codigoBarras = codigoBarras;
		this.nomeProduto = nomeProduto;
		this.aliquotaIcms = aliquotaIcms;
		this.margemLucro = margemLucro;
		this.custoMedioUnitario = custoMedioUnitario;
		this.precoVenda = precoVenda;
	}

	public void atualizarPrecoVenda(double custo) {
	    double precoCalculado = custo / (1 - (this.aliquotaIcms + this.margemLucro) / 100);
	    String precoFormatadoStr = String.format("%.2f", precoCalculado);
	    this.precoVenda = Double.parseDouble(precoFormatadoStr.replace(",", "."));
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
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

	public double getAliquotaIcms() {
		return aliquotaIcms;
	}

	public void setAliquotaIcms(double aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public double getCustoMedioUnitario() {
		return custoMedioUnitario;
	}

	public void setCustoMedioUnitario(double custoMedioUnitario) {
		this.custoMedioUnitario = custoMedioUnitario;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aliquotaIcms, codigoBarras, custoMedioUnitario, margemLucro, nomeProduto, precoVenda,
				produtoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Double.doubleToLongBits(aliquotaIcms) == Double.doubleToLongBits(other.aliquotaIcms)
				&& Objects.equals(codigoBarras, other.codigoBarras)
				&& Double.doubleToLongBits(custoMedioUnitario) == Double.doubleToLongBits(other.custoMedioUnitario)
				&& Double.doubleToLongBits(margemLucro) == Double.doubleToLongBits(other.margemLucro)
				&& Objects.equals(nomeProduto, other.nomeProduto)
				&& Double.doubleToLongBits(precoVenda) == Double.doubleToLongBits(other.precoVenda)
				&& produtoId == other.produtoId;
	}

	@Override
	public String toString() {
		return "Produto [produtoId=" + produtoId + ", codigoBarras=" + codigoBarras + ", nomeProduto=" + nomeProduto
				+ ", aliquotaIcms=" + aliquotaIcms + ", margemLucro=" + margemLucro + ", custoMedioUnitario="
				+ custoMedioUnitario + ", precoVenda=" + precoVenda + "]";
	}

}
