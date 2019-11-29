package br.abastecimento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pluviometria")
public class Pluviometria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pluviometria")
	private int id_pluviometria;
	
	@ManyToOne
	@JoinColumn(name = "id_represa")
	private Represa represa;
	
	@NotNull
	@Column(name = "pluviometria")
	private int pluviometria;

	public int getId_pluviometria() {
		return id_pluviometria;
	}

	public void setId_pluviometria(int id_pluviometria) {
		this.id_pluviometria = id_pluviometria;
	}

	public Represa getRepresa() {
		return represa;
	}

	public void setRepresa(Represa represa) {
		this.represa = represa;
	}

	public int getPluviometria() {
		return pluviometria;
	}

	public void setPluviometria(int pluviometria) {
		this.pluviometria = pluviometria;
	}


}
