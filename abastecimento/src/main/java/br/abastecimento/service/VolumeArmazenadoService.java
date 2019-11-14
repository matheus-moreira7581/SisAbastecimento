package br.abastecimento.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.abastecimento.dao.VolumeArmazenadoDAO;
import br.abastecimento.entity.Represa;
import br.abastecimento.entity.VolumeArmazenado;

@Service
@Transactional
public class VolumeArmazenadoService {
	private VolumeArmazenadoDAO dao;
	
	@Autowired
	public VolumeArmazenadoService(VolumeArmazenadoDAO dao) {
		this.dao = dao;
	}
	
	public int registrarVolArmazenado(VolumeArmazenado volArmazenado) throws IOException{
		return dao.inserirVolArmazenado(volArmazenado);
	}
	
	public List<VolumeArmazenado> listarVolArmazenado(Represa represa) throws IOException {
		return dao.listarVolArmazenado(represa);
	}
}
