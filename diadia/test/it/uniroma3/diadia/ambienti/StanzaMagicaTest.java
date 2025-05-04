package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	StanzaMagica magic;
	Attrezzo piz;
	Attrezzo zip;
	Attrezzo roccia;
	
	@BeforeEach
	void setUp(){
		magic=new StanzaMagica("maggica", 1);
		piz=new Attrezzo("piz", 1);
		zip=new Attrezzo("zip", 1);
		roccia=new Attrezzo("roccia",10);
		magic.addAttrezzo(piz);
		magic.addAttrezzo(zip);
		magic.addAttrezzo(roccia);
		
		
		
	}

	@Test
	void testModificaNomeTrue() {
		assertEquals(magic.getAttrezzi()[1].getNome(), piz.getNome());
	}
	@Test
	void testModificaPesoTrue() {
		assertEquals(magic.getAttrezzi()[1].getPeso(), 2);
	}
	@Test 
	void testModificaPiuUno() {
		assertEquals(magic.getAttrezzi()[2].getNome(), "aiccor");
	}

}
