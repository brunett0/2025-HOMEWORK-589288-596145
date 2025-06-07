package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita partita;
	Stanza nuovaStanza;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto_test.txt").getLabirinto();
		partita = new Partita(labirinto);
		nuovaStanza = new Stanza("Salone");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("SalaSegreta", partita.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(nuovaStanza);
		assertEquals(nuovaStanza, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		assertFalse(partita.isFinita());
	}
}

