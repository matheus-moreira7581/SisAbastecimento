package abastecimento.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.abastecimento.controller.ManterAbastecimentoController;
import br.abastecimento.dao.RepresaDAO;
import br.abastecimento.dao.SisAbastecimentoDAO;
import br.abastecimento.entity.Represa;
import br.abastecimento.service.RepresaService;

class RepresaTest {
	private RepresaDAO dao;
	private SisAbastecimentoDAO sisAbsDao;
	RepresaService represaService;
	Represa represa;
	ManterAbastecimentoController controller;
	
	
	@Before
	public void setUp() throws Exception {
		represaService = new RepresaService(dao, sisAbsDao);
		represa = new Represa();
		controller = new ManterAbastecimentoController();
		
	}
	
	@Test
	public void testeNãoNulo() {
		
		assertNotNull("Objeta represa não-nulo", represa);
	}
	
	@Test
	public void testeIgualdade() {
		
		assertEquals("Verificação de objetos", represa, new Represa());
	}
	
	@Test
	public void TesteCalcularIndices() {
		
		represa.setVolumeReservaTecnica(5000);
		represa.setVolumeUtil(5000);
		
		float reservaTecnica = represa.getVolumeReservaTecnica();
		float volumeUtil = represa.getVolumeUtil();
		
		assertEquals("O volume total deve ser a soma do volume técnico e volume útil ", controller.calcularVolTotal(volumeUtil, reservaTecnica), 10000.0, 100.0);
	}
	
	@Test
	public void testeNaoIgualdade() {
		
		Represa represa = new Represa();
		Represa represa2 = new Represa();
		
		assertNotSame("Teste de igualdade de classe", represa, represa2);
	}
	
	@Test
	public void testeIgualdadeObjetos() {
		
		Represa represa = new Represa();
		
		assertSame("Teste de igualdade de classe", represa, represa);
	}

}
