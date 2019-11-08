package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.RepresaDAO;
import br.abastecimento.dao.SisAbastecimentoDAO;
import br.abastecimento.entity.Represa;
import br.abastecimento.entity.SisAbastecimento;

@Service
@Transactional
public class RepresaService {
	RepresaDAO dao;
	SisAbastecimentoDAO sisAbsDao;
	
	@Autowired
	public RepresaService(RepresaDAO dao, SisAbastecimentoDAO sisAbsDAO) {
		this.dao = dao;
		this.sisAbsDao = sisAbsDAO;
	}
	
	public int novaRepresa(Represa represa) throws IOException {
		represa = prencherLacuna(represa);
		return dao.inserirRepresa(represa);
	}
	
	public Represa prencherLacuna(Represa represa) throws IOException {
		SisAbastecimento sisAbs = sisAbsDao.selecionarSisAbastecimento(represa.getSisAbs().getId());
		represa.setSisAbs(sisAbs);
		return represa;
	}
 	
	public List<Represa> listarTodasRepresas(SisAbastecimento sisAbs) throws IOException {
		return dao.listarRepresa(sisAbs);
	}
	
	public Represa selecionarRepresa(int id) throws IOException {
		return dao.selecionarRepresa(id);
	}
	
	public int atualizarRepresa(Represa represa) throws IOException {
		represa = prencherLacuna(represa);
		return dao.atualizarRepresa(represa);
	}
	
	public void excluirRepresa(int id) throws IOException {
		dao.excluirRepresa(id);
	}
}
