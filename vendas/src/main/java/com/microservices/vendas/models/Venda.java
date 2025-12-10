package com.microservices.vendas.models;

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

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cliente_documento", nullable = false)
    private String clienteDocumento;

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VendaItem> itens = new ArrayList<>();

    public Venda() {
    	
    }

    public Venda(int id, int clienteId, double valorTotal, LocalDate dataVenda, List<VendaItem> itens,
			String clienteDocumento) {
		super();
		this.id = id;
		this.clienteDocumento = clienteDocumento;
		this.valorTotal = valorTotal;
		this.dataVenda = dataVenda;
		this.itens = itens;
		this.clienteDocumento = clienteDocumento;
	}

	public double calcularValorTotal() {
        return itens.stream()
                .mapToDouble(i -> i.getPrecoVenda() * i.getQuantidade())
                .sum();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClienteDocumento() {
		return clienteDocumento;
	}

	public void setClienteDocumento(String clienteDocumento) {
		this.clienteDocumento = clienteDocumento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<VendaItem> getItens() {
		return itens;
	}

	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteDocumento, dataVenda, id, itens, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(dataVenda, other.dataVenda) && id == other.id
				&& Objects.equals(itens, other.itens)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", clienteId=" + ", valorTotal=" + valorTotal + ", dataVenda="
				+ dataVenda + ", itens=" + itens + "]";
	}   

}
