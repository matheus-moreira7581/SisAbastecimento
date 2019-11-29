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
/** Entidade para os dados de pluviometria
 * @version 0.1
 * @author matheus moreira */
@Entity
@Table(name = "pluviometria")
public class Pluviometria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** Recebe o id da pluviometria que é gerado automaticamente.*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pluviometria")
	private int id_pluviometria;
	
	/** Representa uma pojo de uma represa que possui relacionamento com a Pluviometria.*/
	@ManyToOne
	@JoinColumn(name = "id_represa")
	private Represa represa;
	
	/**  Recebe o valor de pluviometria. */
	@NotNull
	@Column(name = "pluviometria")
	private int pluviometria;
	
	/**  Obtem o valor de id_pluviometria
	 * @return Um inteiro representando o id de pluviometria
	 * */
	public int getId_pluviometria() {
		return id_pluviometria;
	}
	/**Seta o valor de id_pluviometria
	 * @param id_pluviometria Um inteiro contendo o id de pluviometria */
	public void setId_pluviometria(int id_pluviometria) {
		this.id_pluviometria = id_pluviometria;
	}
	/** Obtem um POJO de Represa
	 * @return Um POJO da classe Represa*/
	public Represa getRepresa() {
		return represa;
	}
	/**Seta um POJO de represa
	 * @param Represa Um POJO contendo dados de represa */
	public void setRepresa(Represa represa) {
		this.represa = represa;
	}
	/** Obtem o valor inteiro de pluviometria
	 * @return O valor inteiro de pluviometria.
	 */
	public int getPluviometria() {
		return pluviometria;
	}
	/** Seta um valor de pluviometria
	 * @param pluviometria Um inteiro contendo o valor de pluviometria.
	 * */
	public void setPluviometria(int pluviometria) {
		this.pluviometria = pluviometria;
	}


}
