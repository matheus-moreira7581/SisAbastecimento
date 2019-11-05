package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.SisAbastecimentoDAO;
import br.abastecimento.entity.SisAbastecimento;

@Service
public class SisAbastecimentoService {
	SisAbastecimentoDAO dao;
	
	@Autowired
	public SisAbastecimentoService(SisAbastecimentoDAO dao) {
		this.dao = dao;
	}
	
	public int novoSisAbastecimento(SisAbastecimento sisAbs) throws IOException {
		return dao.inserirSisAbastecimento(sisAbs);
	}
	
	public List<SisAbastecimento> selecionarTodosSisAbastecimento() throws IOException {
		return dao.listarSisAbastecimento();
	}
}
