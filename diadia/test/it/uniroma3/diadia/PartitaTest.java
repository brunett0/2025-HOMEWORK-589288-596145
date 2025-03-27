package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	Partita partita;
	Partita partitaVinta;
	Partita partitaNulla;
	
	Partita partitaFinita;
	@BeforeEach
	void setUp() throws Exception {
		partita=new Partita();
		partitaVinta=new Partita();
		partitaNulla=new Partita();
		
		partitaVinta.setStanzaCorrente(partitaVinta.getStanzaVincente());
		
		partitaNulla.getLabirinto().setStanzaVincente(null);
		
		
		partitaFinita=new Partita();
		partitaFinita.setFinita();
		
		partita.getGiocatore().setCfu(0);
		
	}

	@Test
	void testVintaFalso() {
		assertFalse(partita.vinta());
	}
	@Test
	void testVintaVero() {
		assertTrue(partitaVinta.vinta());
	}
	@Test
	void testVintaNull() {
		assertFalse(partitaNulla.vinta());
	}
	
	@Test 
	void testIsFinitaSet() {
		assertTrue(partitaFinita.isFinita());
	}
	@Test 
	void testIsFinitaVinta() {
		assertTrue(partitaVinta.isFinita());
	}
	@Test 
	void testIsFinitaCfu() {
		assertTrue(partita.isFinita());
	}
	

}
