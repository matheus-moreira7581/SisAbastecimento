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
public class Represa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="nomeRepresa")
	private String nomeRepresa;
	
	@NotNull
	@Column(name="volumeUtil")
	private int volumeUtil;
	
	@NotNull
	@Column(name="volumeReservaTecnica")
	private int volumeReservaTecnica;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_abastecimento")
	private SisAbastecimento sisAbs;
	
	public SisAbastecimento getSisAbs() {
		return sisAbs;
	}
	public void setSisAbs(SisAbastecimento sisAbs) {
		this.sisAbs = sisAbs;
	}
	private int volumeArmazenado;
	private int pluviometria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeRepresa() {
		return nomeRepresa;
	}
	public void setNomeRepresa(String nomeRepresa) {
		this.nomeRepresa = nomeRepresa;
	}
	public int getVolumeUtil() {
		return volumeUtil;
	}
	public void setVolumeUtil(int volumeUtil) {
		this.volumeUtil = volumeUtil;
	}
	public int getVolumeReservaTecnica() {
		return volumeReservaTecnica;
	}
	public void setVolumeReservaTecnica(int volumeReservaTecnica) {
		this.volumeReservaTecnica = volumeReservaTecnica;
	}
	public int getVolumeArmazenado() {
		return volumeArmazenado;
	}
	public void setVolumeArmazenado(int volumeArmazenado) {
		this.volumeArmazenado = volumeArmazenado;
	}
	public int getPluviometria() {
		return pluviometria;
	}
	public void setPluviometria(int pluviometria) {
		this.pluviometria = pluviometria;
	}
	
}
