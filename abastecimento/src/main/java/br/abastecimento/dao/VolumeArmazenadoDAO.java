package br.abastecimento.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.abastecimento.entity.Represa;
import br.abastecimento.entity.VolumeArmazenado;

@Repository
public class VolumeArmazenadoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public int inserirVolArmazenado(VolumeArmazenado volumeArmazeando) throws IOException {
		manager.persist(volumeArmazeando);
		return volumeArmazeando.getId_volumeArmazenado();
	}
	
	@SuppressWarnings("unchecked")
	public List<VolumeArmazenado> listarVolArmazenado(Represa represa) throws IOException {
		represa = manager.find(Represa.class, represa.getId());
		
		String jpql = "select v from VolumeArmazenado v where v.represa = :represa ORDER BY v.id_volumeArmazenado DESC";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("represa", represa);
		
		List<VolumeArmazenado> result = query.getResultList();
		return result;
	}
}
