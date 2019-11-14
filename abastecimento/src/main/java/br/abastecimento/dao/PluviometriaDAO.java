package br.abastecimento.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.abastecimento.entity.Pluviometria;
import br.abastecimento.entity.Represa;

@Repository
public class PluviometriaDAO {
	@PersistenceContext
	EntityManager manager;
	
	public int inserirPluviometria(Pluviometria pluviometria) throws IOException{
		manager.persist(pluviometria);
		return pluviometria.getId_pluviometria();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pluviometria> listarPluviometria(Represa represa) throws IOException {
		represa = manager.find(Represa.class, represa.getId());
		
		String jpql = "select p from Pluviometria p where p.represa = :represa ORDER BY p.id_pluviometria DESC";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("represa", represa);
		
		List<Pluviometria> result = query.getResultList();
 		return result;
	}
}
