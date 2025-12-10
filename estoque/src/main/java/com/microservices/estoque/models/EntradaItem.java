package com.microservices.estoque.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "entrada_itens")
public class EntradaItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entrada_item_id")
	private int entradaItemId;
	
	@Column(name = "produto_id", nullable = false)
    private int produtoId;

    @ManyToOne
    @JoinColumn(name = "entrada_id", nullable = false)
    @JsonBackReference
    private Entrada entrada;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    
    @Transient
    private String codigoBarras;

	public EntradaItem() {
		super();
	}

	public EntradaItem(int entradaItemId, int produtoId, Entrada entrada, int quantidade, double valorUnitario,
			String codigoBarras) {
		super();
		this.entradaItemId = entradaItemId;
		this.produtoId = produtoId;
		this.entrada = entrada;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.codigoBarras = codigoBarras;
	}

	public int getEntradaItemId() {
		return entradaItemId;
	}

	public void setEntradaItemId(int entradaItemId) {
		this.entradaItemId = entradaItemId;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoBarras, entrada, entradaItemId, produtoId, quantidade, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaItem other = (EntradaItem) obj;
		return Objects.equals(codigoBarras, other.codigoBarras) && Objects.equals(entrada, other.entrada)
				&& entradaItemId == other.entradaItemId && produtoId == other.produtoId
				&& quantidade == other.quantidade
				&& Double.doubleToLongBits(valorUnitario) == Double.doubleToLongBits(other.valorUnitario);
	}

	@Override
	public String toString() {
		return "EntradaItem [entradaItemId=" + entradaItemId + ", produtoId=" + produtoId + ", entrada=" + entrada
				+ ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", codigoBarras=" + codigoBarras
				+ "]";
	}

	
}
