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

class ComandoPrendiTest {
	Partita partita;
	Stanza stanza;
	Attrezzo lancia;
	Attrezzo forchetta;
	Comando comando;
	
	FabbricaDiComandi fabbrica;
	IO console;
	@BeforeEach
	void setUp() {
	console=new IOConsole();
	fabbrica=new FabbricaDiComandiFisarmonica(console);
	
			
	partita= new Partita();
	stanza= new Stanza("aula1");
	
	partita.setStanzaCorrente(stanza);
	
	lancia=new Attrezzo("lancia", 4);
	forchetta= new Attrezzo("forchetta", 1);
	stanza.addAttrezzo(lancia);
	stanza.addAttrezzo(forchetta);
	

	
	comando=fabbrica.costruisciComando("prendi");
	comando.setParametro("lancia");
	comando.esegui(partita);
	

	
	}

	@Test
	void testPreso() {
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("lancia"));
	}
	@Test
	void testSecondoAttrezzoRimane() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("forchetta"));
	}
	@Test
	void testAttrezzoPresenteBorsa() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lancia"));
	}

}
