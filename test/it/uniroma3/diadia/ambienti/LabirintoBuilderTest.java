package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	LabirintoBuilder builder;

	@Before
	public void setUp() throws Exception {
		builder = new LabirintoBuilder("labirinto_custom.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(builder.getLabirinto());
		assertEquals(Labirinto.class, builder.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		builder.addStanza("ripostiglio");
		Stanza attesa = new Stanza("ripostiglio");
		assertEquals(attesa, builder.getNome2stanza().get("ripostiglio"));
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class, builder.addAttrezzo("martello", 5).getClass());
	}

	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta() {
		builder.addStanzaIniziale("officina").addAttrezzo("tenaglia", 2);
		Attrezzo atteso = new Attrezzo("tenaglia", 2);
		assertEquals(atteso, builder.getLabirinto().getStanzaCorrente().getAttrezzo("tenaglia"));
	}

	@Test
	public void testAddAttrezzoConStanza() {
		builder.addStanza("deposito");
		builder.addAttrezzo("chiave", 1);
		assertTrue(builder.getNome2stanza().get("deposito").hasAttrezzo("chiave"));
	}
}



