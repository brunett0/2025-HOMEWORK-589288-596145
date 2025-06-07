package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaLibera;
	private Attrezzo chiave;

	@Before
	public void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("Portone", Direzione.NORD, "chiave");
		stanzaLibera = new Stanza("Atrio");
		chiave = new Attrezzo("chiave", 1);
		stanzaBloccata.impostaStanzaAdiacente(Direzione.NORD, stanzaLibera);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaLibera, stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}

	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String expected = "Stanza bloccata nella direzione: nord\nPrendi il chiave e posalo nella stanza";
		assertEquals(expected, stanzaBloccata.getDescrizione());
	}
}

