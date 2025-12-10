package com.microservices.vendas.models;

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

@Entity
@Table(name = "venda_itens")
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_barras", nullable = false)
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    @JsonBackReference
    private Venda venda;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_venda", nullable = false)
    private double precoVenda;

	public VendaItem() {
		super();
	}

	public VendaItem(int id, String codigoBarras, Venda venda, int quantidade, double precoVenda) {
		super();
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.venda = venda;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoBarras, id, precoVenda, quantidade, venda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaItem other = (VendaItem) obj;
		return Objects.equals(codigoBarras, other.codigoBarras) && id == other.id
				&& Double.doubleToLongBits(precoVenda) == Double.doubleToLongBits(other.precoVenda)
				&& quantidade == other.quantidade && Objects.equals(venda, other.venda);
	}

	@Override
	public String toString() {
		return "VendaItem [id=" + id + ", codigoBarras=" + codigoBarras + ", venda=" + venda + ", quantidade="
				+ quantidade + ", precoVenda=" + precoVenda + "]";
	}
    
}
