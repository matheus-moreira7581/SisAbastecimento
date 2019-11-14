package br.abastecimento.entity;

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
@Table(name = "volumearmazenado")
public class VolumeArmazenado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_volumeArmazenado")
	private int id_volumeArmazenado;
	
	@ManyToOne
	@JoinColumn(name="id_represa")
	private Represa represa;
	
	@NotNull
	@Column(name = "volumeArmazenado")
	private int volumeArmazenado;

	public int getId_volumeArmazenado() {
		return id_volumeArmazenado;
	}

	public void setId_volumeArmazenado(int id_volumeArmazenado) {
		this.id_volumeArmazenado = id_volumeArmazenado;
	}

	public Represa getRepresa() {
		return represa;
	}

	public void setRepresa(Represa represa) {
		this.represa = represa;
	}

	public int getVolumeArmazenado() {
		return volumeArmazenado;
	}

	public void setVolumeArmazenado(int volumeArmazenado) {
		this.volumeArmazenado = volumeArmazenado;
	}
}
