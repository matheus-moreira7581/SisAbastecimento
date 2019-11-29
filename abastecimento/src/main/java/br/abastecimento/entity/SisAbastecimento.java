package br.abastecimento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="abastecimento")
public class SisAbastecimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_abastecimento")
	private int id;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@NotNull
	@Column(name="estado")
	private String estado;
	
	@NotNull
	@Column(name="municipio")
	private String municipio;
	
	@NotNull
	@Column(name="deletado")
	private String deletado;
	
	public static final String SIM = "sim";
	public static final String NAO = "nao";

	public String getDeletado() {
		return deletado;
	}

	public void setDeletado(String deletado) {
		this.deletado = deletado;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {
		return "SisAbastecimento [id=" + id + ", nome=" + nome + ", estado=" + estado + ", municipio=" + municipio
				+ ", deletado=" + deletado + "]";
	}
}
