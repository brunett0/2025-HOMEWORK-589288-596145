package it.uniroma3.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	FabbricaDiComandi fabbrica;
	Comando comandoNonValido;
	Comando comandoVai;
	Comando comandoPrendi;
	Comando comandoPosa;
	Comando comandoAiuto;
	Comando comandoFine;
	Comando comandoGuarda;
	IO console;
	@BeforeEach
	void setUp() throws Exception {
		console=new IOConsole();
		fabbrica=new FabbricaDiComandiFisarmonica(console);
		
		comandoNonValido=fabbrica.costruisciComando("abcd");
		
		comandoVai=fabbrica.costruisciComando("vai");
		comandoVai.setParametro("nord");
		
		comandoPrendi=fabbrica.costruisciComando("prendi");
		comandoPrendi.setParametro("banana");
		
		comandoPosa=fabbrica.costruisciComando("posa");
		comandoPosa.setParametro("banana");
		
		comandoAiuto=fabbrica.costruisciComando("aiuto");
		
		comandoFine=fabbrica.costruisciComando("fine");
		
		comandoGuarda=fabbrica.costruisciComando("guarda");
	}

	@Test
	void testNonValido() {
		assertEquals(comandoNonValido.getNome(), "non valido");
	}
	@Test
	void testVai() {
		assertEquals(comandoVai.getNome(), "vai");
		assertEquals(comandoVai.getParametro(), "nord");
	}
	@Test
	void testPrendi() {
		assertEquals(comandoPrendi.getNome(), "prendi");
		assertEquals(comandoPrendi.getParametro(), "banana");
	}
	@Test
	void testPosa() {
		assertEquals(comandoPosa.getNome(), "posa");
		assertEquals(comandoPosa.getParametro(), "banana");
	}
	@Test
	void testAiuto() {
		assertEquals(comandoAiuto.getNome(), "aiuto");
	}
	@Test
	void testFine() {
		assertEquals(comandoFine.getNome(), "fine");
	}
	@Test
	void testGuarda() {
		assertEquals(comandoGuarda.getNome(), "guarda");
	}
	
	
	

}
