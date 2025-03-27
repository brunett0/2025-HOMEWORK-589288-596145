package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	Stanza stanza;
	Stanza stanzaAdiacente;
	Attrezzo cucchiaio;
	Attrezzo ramo;
	@BeforeEach
	void setUp() {
		stanza=new Stanza("stanza");
		stanzaAdiacente=new Stanza("stanzaAdiacente");
		cucchiaio=new Attrezzo("cucchiaio", 10);
		ramo=new Attrezzo("ramo", 2);
		
		stanza.addAttrezzo(cucchiaio);
		stanza.addAttrezzo(ramo);
		
		stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);
		stanzaAdiacente.addAttrezzo(cucchiaio);	
		
		System.out.println(stanza.toString());		
	}

	@Test
	void testGetStanzaAdiacenteTrue() {
		assertEquals(stanza.getStanzaAdiacente("nord"), stanzaAdiacente);
	}
	@Test
	void testGetStanzaAdiacenteNull() {
		assertNull(stanza.getStanzaAdiacente("cane"));
	}
	@Test
	void testGetStanzaAdiacenteFalse() {
		assertNotEquals(stanza.getStanzaAdiacente("sud"), stanzaAdiacente);
	}
	@Test 
	void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(cucchiaio));
	}
	@Test 
	void testAddAttrezzoStanzaPiena() {
		assertFalse(stanzaAdiacente.addAttrezzo(cucchiaio));
	}
	@Test
	void testHasAttrezzoPiena() {
		assertTrue(stanzaAdiacente.hasAttrezzo("cucchiaio"));
	}
	@Test
	void testHasAttrezzoUno() {
		assertTrue(stanza.hasAttrezzo("ramo"));
	}
	
	
	
	

}
