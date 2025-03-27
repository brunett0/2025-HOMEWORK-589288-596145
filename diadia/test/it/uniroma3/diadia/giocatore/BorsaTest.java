package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


class BorsaTest {
	
	Borsa borsa;
	Borsa borsavuota;
	Attrezzo spada;
	Attrezzo scudo;

	@BeforeEach
	void setUp() {
		
		/*scenario per removeAttrezzo(nomeAtrrezzo) */
		borsa=new Borsa();
		borsavuota=new Borsa();
		spada=new Attrezzo("spada", 3);
		scudo=new Attrezzo("scudo", 4);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(scudo);
		borsa.removeAttrezzo("spada");

		
	}

	@Test
	void testRemoveAttrezzoEsistente() {
		assertEquals(scudo, borsa.removeAttrezzo("scudo"));
	}
	@Test
	void testRemoveAttrezzoNull() {
		assertNull(borsa.removeAttrezzo("cucchiaio"));
	}
	@Test 
	void testRemoveAttrezzoBorsaVuota() {
		assertNull(borsavuota.removeAttrezzo("jjgun"));
	}
	
	@Test
	void testGetNumeroAttrezziCorretto() {
		assertEquals(1, borsa.getNumeroAttrezzi());
	}
	
	@Test 
	void testIsEmpty() {
		assertTrue(borsavuota.isEmpty());
		
	}

}
