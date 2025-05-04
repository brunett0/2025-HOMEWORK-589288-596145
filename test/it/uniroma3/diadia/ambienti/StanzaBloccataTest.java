package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	Stanza normale;
	Stanza bloccata;
	Stanza destra;
	Attrezzo cacciavite;
	@BeforeEach
	void setUp() throws Exception {
		normale=new Stanza("cassaforte");
		bloccata=new StanzaBloccata("banca", "nord", "chiave");
		destra=new StanzaBloccata("destra", "sud", "cacciavite");
		
		cacciavite=new Attrezzo("cacciavite", 2);
		
		bloccata.impostaStanzaAdiacente("nord", normale);
		bloccata.impostaStanzaAdiacente("destra", destra);
		
		destra.impostaStanzaAdiacente("sud", bloccata);
		destra.addAttrezzo(cacciavite);
	}

	@Test
	void testBloccata() {
		assertEquals(bloccata.getStanzaAdiacente("nord"), bloccata);
	}
	@Test
	void testSpostaVersoNonBloccataDaStanzaBloccata() {
		assertEquals(bloccata.getStanzaAdiacente("destra"), destra);
	}
	@Test 
	void testApriPorta(){
		assertEquals(destra.getStanzaAdiacente("sud"), bloccata);
	}
}
