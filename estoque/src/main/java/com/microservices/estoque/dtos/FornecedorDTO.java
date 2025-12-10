package com.microservices.estoque.dtos;

import java.util.Objects;

public class FornecedorDTO {
	
	private int id;
	private String nome;
	private String documento;
	
	public FornecedorDTO(int id, String nome, String documento) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return Objects.hash(documento, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorDTO other = (FornecedorDTO) obj;
		return Objects.equals(documento, other.documento) && id == other.id && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nome=" + nome + ", documento=" + documento + "]";
	}
}
