package br.abastecimento.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.abastecimento.entity.SisAbastecimento;

@Repository
public class SisAbastecimentoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public int inserirSisAbastecimento(SisAbastecimento sisAbs) throws IOException {
		manager.persist(sisAbs);
		return sisAbs.getId();
	}
	
	public void excluirSisAbastecimento(SisAbastecimento sisAbs) throws IOException {
		manager.merge(sisAbs);
	}
	
	public SisAbastecimento selecionarSisAbastecimento(int id) throws IOException {
		return manager.find(SisAbastecimento.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<SisAbastecimento> listarSisAbastecimento() throws IOException {
		return manager.createQuery("select s from SisAbastecimento s").getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<SisAbastecimento> listarSisAbastecimentoAtivos() throws IOException {
		String jpql = "select s from SisAbastecimento s where s.deletado = :deletado";
		Query query = manager.createQuery(jpql);
		query.setParameter("deletado", SisAbastecimento.NAO);
		List<SisAbastecimento> result = query.getResultList();
		return result;
	}
	
	public void atualizarSisAbastecimento(SisAbastecimento sisAbs) throws IOException {
		manager.merge(sisAbs);
	}
}
