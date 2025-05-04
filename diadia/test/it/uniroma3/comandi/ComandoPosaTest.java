package it.uniroma3.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class ComandoPosaTest {
	Partita partita;
	Partita partita2;
	
	Stanza stanza;
	Stanza stanza2;
	
	Attrezzo lancia;
	Attrezzo forchetta;
	Attrezzo portafoglio;
	Comando comando;
	Comando comando2;
	
	FabbricaDiComandi fabbrica;
	
	IO console;
	
	
	@BeforeEach
	void setUp() {
	console=new IOConsole();
	fabbrica=new FabbricaDiComandiFisarmonica(console);
	
			
	partita= new Partita();
	partita2= new Partita();
	stanza= new Stanza("aula1");
	stanza2=new Stanza("aula2");
	
	partita.setStanzaCorrente(stanza);
	partita2.setStanzaCorrente(stanza2);
	
	
	lancia=new Attrezzo("lancia", 4);
	forchetta= new Attrezzo("forchetta", 1);
	portafoglio=new Attrezzo("portafoglio", 0);
	
	stanza.addAttrezzo(lancia);
	stanza.addAttrezzo(forchetta);
	
	
	partita.getGiocatore().getBorsa().addAttrezzo(portafoglio);
	

	
	comando=fabbrica.costruisciComando("posa");
	comando.setParametro("portafoglio");
	comando.esegui(partita);
	
	comando2=fabbrica.costruisciComando("posa");
	comando2.setParametro("portafoglio");
	comando2.esegui(partita2);
	
	
	

	
	}

	@Test
	void testAttrezzoPosatoStanza() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("portafoglio"));
	}
	@Test
	void testAttrezzoPosatoBorsa() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("portafoglio"));
	}
	@Test
	void testPosizioneAttrezzi() {
		assertEquals(partita.getStanzaCorrente().getAttrezzi()[0].toString(), lancia.toString());
		assertEquals(partita.getStanzaCorrente().getAttrezzi()[1].toString(), forchetta.toString());
		assertEquals(partita.getStanzaCorrente().getAttrezzi()[2].toString(), portafoglio.toString());
	}
	@Test
	void testAttrezzoInesistentePosatoStanza() {
		assertFalse(partita2.getStanzaCorrente().hasAttrezzo("portafoglio"));
	}

}
