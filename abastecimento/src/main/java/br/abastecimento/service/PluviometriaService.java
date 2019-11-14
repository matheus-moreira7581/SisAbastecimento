package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.PluviometriaDAO;
import br.abastecimento.entity.Pluviometria;
import br.abastecimento.entity.Represa;

@Service
@Transactional
public class PluviometriaService {
	private PluviometriaDAO dao;
	
	@Autowired
	public PluviometriaService(PluviometriaDAO dao) {
		this.dao = dao;
	}
	
	public int registrarPluviometria(Pluviometria pluviometria) throws IOException {
		return dao.inserirPluviometria(pluviometria);
	}
	
	public List<Pluviometria> listarPluviometria(Represa represa) throws IOException {
		return dao.listarPluviometria(represa);
	}
	
}
