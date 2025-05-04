package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String direzione;
	private IO console;
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente(); 
		Stanza prossimaStanza = null;
		if (this.direzione==null) {
			console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		return;
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza==null){
			console.mostraMessaggio("Direzione inesistente");
		return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		console.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1) ;
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione=parametro;
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return direzione;
	}
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		console=io;
	}
}
