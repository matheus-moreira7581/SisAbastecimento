package br.abastecimento.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.abastecimento.entity.Represa;

@Repository
public class RepresaDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public int inserirRepresa(Represa represa) throws IOException {
		manager.persist(represa);
		return represa.getId();
	}
	
	public void excluirRepresa(int id) throws IOException {
		Represa represa = manager.find(Represa.class, id);
		manager.remove(represa);
	}
	
	public Represa selecionarRepresa(int id) throws IOException {
		return manager.find(Represa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Represa> listarRepresa() throws IOException {
		return manager.createQuery("select r from Represa r").getResultList();
	}
	
	public int atualizarRepresa(Represa represa) throws IOException {
		Represa represa2 = manager.merge(represa);
		return represa.getId();
	}
}
