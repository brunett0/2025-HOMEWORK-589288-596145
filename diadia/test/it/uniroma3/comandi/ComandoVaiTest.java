package it.uniroma3.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class ComandoVaiTest {
	Partita partita;
	Partita partita2;
	Partita partita3;
	FabbricaDiComandi fabbrica;
	Comando comando;
	Comando comando2;
	Comando comando3;
	Stanza stanza1;
	Stanza stanza2;
	IO console;
	@BeforeEach
	void setUp() {
		console=new IOConsole();
		
		partita=new Partita();
		partita2= new Partita();
		partita3=new Partita();
		
		fabbrica= new FabbricaDiComandiFisarmonica(console);
		
		stanza1=new Stanza("aula1");
		stanza2=new Stanza("aula2");
		
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		stanza2.impostaStanzaAdiacente("sud", stanza1);
		
		partita.setStanzaCorrente(stanza1);
		comando=fabbrica.costruisciComando("vai");
		comando.setParametro("nord");
		comando.esegui(partita);
		
		partita2.setStanzaCorrente(stanza1);
		comando2=fabbrica.costruisciComando("vai");
		comando2.setParametro("est");
		comando2.esegui(partita2);
		
		partita3.setStanzaCorrente(stanza1);
		comando3=fabbrica.costruisciComando("vai");
		comando3.esegui(partita3);
		
		
		
	}

	@Test
	void testSiSpostamenti() {
		assertEquals(partita.getStanzaCorrente().getNome(),"aula2");
	}
	@Test
	void testNoSpostamenti() {
		assertEquals(partita2.getStanzaCorrente().getNome(),"aula1");
	}
	@Test
	void testNUllSpostamenti() {
		assertEquals(partita3.getStanzaCorrente().getNome(),"aula1");
	}
	

}
