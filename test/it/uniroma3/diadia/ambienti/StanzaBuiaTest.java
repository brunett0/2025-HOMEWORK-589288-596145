package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	Stanza buia2;
	Stanza buia;
	Stanza buia3;
	Attrezzo focaccia;
	Attrezzo forno;
	@BeforeEach
	void setUp() throws Exception {
		
		buia=new StanzaBuia("buia", "focaccia");
		buia2=new StanzaBuia("buia2", "focaccia");
		buia3=new StanzaBuia("buia3", "yoyo");
		
		focaccia=new Attrezzo("focaccia", 1);
		forno=new Attrezzo("forno", 9);
	
		buia.addAttrezzo(forno);
		
		buia2.addAttrezzo(focaccia);
		
	}

	@Test
	void testBuioSi() {
		assertEquals(buia.getDescrizione(), "quì c'è buio pesto");
	}
	@Test
	void testBuiaNo() {
		assertEquals(buia2.getDescrizione(), buia2.toString());
	}
	@Test 
	void testVuota(){
		assertEquals(buia3.getDescrizione(), "quì c'è buio pesto");
	}

}
