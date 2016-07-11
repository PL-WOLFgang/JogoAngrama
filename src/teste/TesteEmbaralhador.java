package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import embaralhador.EmbaralhaInverso;
import embaralhador.EmbaralhaSilaba;
import embaralhador.Embaralhador;

public class TesteEmbaralhador {

	Embaralhador embaralha;
	
	@Test
	public void testeEmbaralhaInverso() {
		embaralha = new EmbaralhaInverso();
		assertTrue(embaralha.embaralharPalavra("COLONIA").equals("AINOLOC"));
	}
	
	@Test
	public void testeEmbaralhaSilabaImpar() {
		embaralha = new EmbaralhaSilaba();
		assertTrue(embaralha.embaralharPalavra("MONTE").equals("OMTNE"));
	}
	
	@Test
	public void testeEmbaralhaSilabaPar() {
		embaralha = new EmbaralhaSilaba();
		assertTrue(embaralha.embaralharPalavra("CASO").equals("ACOS"));
	}	

}
