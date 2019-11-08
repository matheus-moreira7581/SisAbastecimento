package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.RepresaDAO;
import br.abastecimento.entity.Represa;
import br.abastecimento.entity.SisAbastecimento;

@Service
public class RepresaService {
	RepresaDAO dao;
	
	@Autowired
	public RepresaService(RepresaDAO dao) {
		this.dao = dao;
	}
	
	public int novaRepresa(Represa represa) throws IOException {
		return dao.inserirRepresa(represa);
	}
	
	public List<Represa> listarTodasRepresas(SisAbastecimento sisAbs) throws IOException {
		return dao.listarRepresa(sisAbs);
	}
	
	public Represa selecionarRepresa(int id) throws IOException {
		return dao.selecionarRepresa(id);
	}
}
