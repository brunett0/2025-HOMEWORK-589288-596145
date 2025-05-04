package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private IO console;
	String nomeattrezzo=null;
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo;
		if (nomeattrezzo!=null) {
			if (partita.getStanzaCorrente().hasAttrezzo(nomeattrezzo)==true) {
				attrezzo=partita.getStanzaCorrente().getAttrezzo(nomeattrezzo);
				@SuppressWarnings("unused")
				boolean riuscito=partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				if (riuscito=false)
					console.mostraMessaggio("impossibile aggiungere");
				console.mostraMessaggio("hai aggiunto"+ " "+ attrezzo.toString());
				riuscito=partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				if (riuscito=false)
					console.mostraMessaggio("impossibile rimuovere dalla stanza");
				console.mostraMessaggio("attrezzo rimosso dalla stanza");
				
			}
			else console.mostraMessaggio("attrezzo inesistente");
		}
		else console.mostraMessaggio("scrivi un attrezzo!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeattrezzo=parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		String stringa="prendi";
		return stringa;
	}

	@Override
	public String getParametro() {
		
		return nomeattrezzo;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		console=io;
	}

}
