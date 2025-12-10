package com.microservices.estoque.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "entradas")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entrada_id")
	private int entradaId;
	
	@Column(name = "fornecedor_documento", nullable = false)
	private String fornecedor;
	
    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @OneToMany(mappedBy = "entrada", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<EntradaItem> itens = new ArrayList<>();
    
    @Transient
    private String clienteDocumento;

	public Entrada() {
		super();
	}

	public Entrada(int entradaId, String fornecedor, double valorTotal, LocalDate dataEntrada, List<EntradaItem> itens,
			String clienteDocumento) {
		super();
		this.entradaId = entradaId;
		this.fornecedor = fornecedor;
		this.valorTotal = valorTotal;
		this.dataEntrada = dataEntrada;
		this.itens = itens;
		this.clienteDocumento = clienteDocumento;
	}
	
	public double calcularValorTotal() {
        return itens.stream()
                .mapToDouble(i -> i.getValorUnitario() * i.getQuantidade())
                .sum();
    }

	public int getEntradaId() {
		return entradaId;
	}

	public void setEntradaId(int entradaId) {
		this.entradaId = entradaId;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public List<EntradaItem> getItens() {
		return itens;
	}

	public void setItens(List<EntradaItem> itens) {
		this.itens = itens;
	}

	public String getClienteDocumento() {
		return clienteDocumento;
	}

	public void setClienteDocumento(String clienteDocumento) {
		this.clienteDocumento = clienteDocumento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteDocumento, dataEntrada, entradaId, fornecedor, itens, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(clienteDocumento, other.clienteDocumento)
				&& Objects.equals(dataEntrada, other.dataEntrada) && entradaId == other.entradaId
				&& fornecedor == other.fornecedor && Objects.equals(itens, other.itens)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal);
	}

	@Override
	public String toString() {
		return "Entrada [entradaId=" + entradaId + ", fornecedorId=" + fornecedor + ", valorTotal=" + valorTotal
				+ ", dataEntrada=" + dataEntrada + ", itens=" + itens + ", clienteDocumento=" + clienteDocumento + "]";
	}

}
