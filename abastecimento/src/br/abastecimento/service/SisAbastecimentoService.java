package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.SisAbastecimentoDAO;
import br.abastecimento.entity.SisAbastecimento;

@Service
@Transactional
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
	
	public SisAbastecimento selecionarSisAbastecimento(int id) throws IOException {
		return dao.selecionarSisAbastecimento(id);
	}
	
	public void excluirSisAbastecimento(int id) throws IOException {
		dao.excluirSisAbastecimento(id);
	}
	
	public void atualizarSisAbastecimento(SisAbastecimento sisAbs) throws IOException {
		dao.atualizarSisAbastecimento(sisAbs);
	}
}
