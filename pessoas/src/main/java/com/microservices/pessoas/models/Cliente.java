package com.microservices.pessoas.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cliente_id;
	
	@Column(name = "nome", nullable = false, length = 200)
	private String nome;
	
	@Column(name = "documento", unique = true, nullable = false)
	private String documento;

	public Cliente() {
		super();
	}

	public Cliente(int cliente_id, String nome, String documento) {
		super();
		this.cliente_id = cliente_id;
		this.nome = nome;
		this.documento = documento;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente_id, documento, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return cliente_id == other.cliente_id && Objects.equals(documento, other.documento)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [cliente_id=" + cliente_id + ", nome=" + nome + ", documento=" + documento + "]";
	}

}
