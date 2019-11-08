package br.abastecimento.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.abastecimento.entity.Represa;
import br.abastecimento.entity.SisAbastecimento;

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
	public List<Represa> listarRepresa(SisAbastecimento sisAbs) throws IOException {
		sisAbs = manager.find(SisAbastecimento.class, sisAbs.getId());
		
		String jpql = "select r from Represa r where r.sisAbs = :sisAbs";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("sisAbs", sisAbs);
		
		List<Represa> result = query.getResultList();
		return result;
	}
	
	public int atualizarRepresa(Represa represa) throws IOException {
		manager.merge(represa);
		return represa.getId();
	}
}
