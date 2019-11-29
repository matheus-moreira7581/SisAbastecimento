package br.abastecimento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
/** Entidade para os dados de Represa
 * @version 0.1
 * @author matheus moreira */
@Entity
public class Represa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**Recebe o id da represa que é gerado automaticamente.  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/** Recebe o nome de uma Represa.*/
	@NotNull
	@Column(name="nomeRepresa")
	private String nomeRepresa;
	
	/** Recebe o volume util de uma represa */
	@NotNull
	@Column(name="volumeUtil")
	private int volumeUtil;
	
	/** Recebe o valor de reserva tecnica de uma represa.*/
	@NotNull
	@Column(name="volumeReservaTecnica")
	private int volumeReservaTecnica;
	
	/** Recebe o pojo de um Sistema de Abastecimento na qual a represa possui relacionamento */
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_abastecimento")
	private SisAbastecimento sisAbs;
	/** Recebe o valor de "nao" ou "sim" para definir se uma represa foi deletada ou não */
	@NotNull
	@Column(name="represaDeletado")
	private String represaDeletado;
	
	public static final String SIM = "sim";
	public static final String NAO = "nao";
	
	/** Obtem o valor de represaDeletado na qual pode ser "nao" ou "sim" 
	 * @return Uma string que pode ser "nao" ou "sim" de represaDeletado*/
	public String getRepresaDeletado() {
		return represaDeletado;
	}
	/** Seta o valor de represaDeletado que pode ser "nao" ou "sim"
	 * @param represaDeletado Uma string na qual pode ser "nao" ou "sim"*/
	public void setRepresaDeletado(String represaDeletado) {
		this.represaDeletado = represaDeletado;
	}
	/** Obtem um POJO de Sistema de Abastecimento
	 * @return SisAbastecimento Um POJO de SisAbastecimento */
	public SisAbastecimento getSisAbs() {
		return sisAbs;
	}
	/**Seta um POJO de Sistema de Abastecimento 
	 * @param SisAbastecimento Um POJO contendo os dados de um Sistema de Abastecimento*/
	public void setSisAbs(SisAbastecimento sisAbs) {
		this.sisAbs = sisAbs;
	}
	/** Obtem um inteiro represetando o id da Represa
	 * @return Um inteiro contendo o id da Represa*/
	public int getId() {
		return id;
	}
	/** Seta o id de uma Represa
	 * @param id Um inteiro que representa o id de uma Represa*/
	public void setId(int id) {
		this.id = id;
	}
	/** Obtem o nome da Represa
	 * @return Uma string contendo o nome da Represa*/
	public String getNomeRepresa() {
		return nomeRepresa;
	}
	/** Seta o nome de uma Represa
	 * @param nomeRepresa Uma string que representa o nome da Represa*/
	public void setNomeRepresa(String nomeRepresa) {
		this.nomeRepresa = nomeRepresa;
	}
	/** Obtem um valor inteiro do Volume Util de uma Represa
	 * @return Um inteiro de Volume Util*/
	public int getVolumeUtil() {
		return volumeUtil;
	}
	/**Seta um valor inteiro de Volume Util de uma Represa
	 * @param volumeUtil Um inteiro que representa o Volume Util de uma Represa */
	public void setVolumeUtil(int volumeUtil) {
		this.volumeUtil = volumeUtil;
	}
	/** Obtem o valor inteiro do Volume de Reserva Tecnica de uma Represa
	 * @return Um inteiro do Volume de Reserva Tecnica*/
	public int getVolumeReservaTecnica() {
		return volumeReservaTecnica;
	}
	/**Seta um valor inteiro do Volume Util de uma Represa
	 * @param volumeReservaTecnica Um inteiro que representa o Volume de Reserva Tecnica de uma Represa */
	public void setVolumeReservaTecnica(int volumeReservaTecnica) {
		this.volumeReservaTecnica = volumeReservaTecnica;
	}
	
	/** Concatena todos os paramentro de uma Represa em uma String 
	 * @return Uma string com todos os parametros de Represa concatenados*/
	@Override
	public String toString() {
		return "Represa [id=" + id + ", nomeRepresa=" + nomeRepresa + ", volumeUtil=" + volumeUtil
				+ ", volumeReservaTecnica=" + volumeReservaTecnica + ", sisAbs=" + sisAbs + ", represaDeletado="
				+ represaDeletado + "]";
	}
	

	
}
