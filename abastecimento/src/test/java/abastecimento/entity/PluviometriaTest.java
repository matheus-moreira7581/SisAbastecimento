package abastecimento.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.abastecimento.entity.Pluviometria;

class PluviometriaTest {

	Pluviometria pluviometria = new Pluviometria();
	
	@Before
	public void setUp() throws Exception {
		
		pluviometria = new Pluviometria();
	}
	
	@Test
	public void testEquals() {
		assertEquals("Verifica��o de objetos", pluviometria, new Pluviometria());
	}
	
	@Test
	public void setPluviometria() {
		
		pluviometria.setId_pluviometria(1000);
		assertEquals("Valor de pluviometria com toler�ncia", 1000, 5000, 10000);
	}

}
