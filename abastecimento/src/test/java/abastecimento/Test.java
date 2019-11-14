package abastecimento;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.abastecimento.dao.SisAbastecimentoDAO;
import br.abastecimento.entity.SisAbastecimento;

@ContextConfiguration(locations = "../WebContent/WEB-INF/spring-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
class Test {
	@Autowired
	private SisAbastecimentoDAO sisAbsDAO;
	
	@org.junit.jupiter.api.Test
	@Transactional
	@Rollback(true)
	public void testAddSisAbs() {
		SisAbastecimento sisAbs = new SisAbastecimento();
		sisAbs.setId(1);
		sisAbs.setEstado("São Paulo");
		sisAbs.setMunicipio("teste");
		sisAbs.setNome("Testing");
		try {
			sisAbsDAO.inserirSisAbastecimento(sisAbs);
			List<SisAbastecimento> lista = sisAbsDAO.listarSisAbastecimento();
			Assert.assertEquals(sisAbs.getNome(), lista.get(0).getNome());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
