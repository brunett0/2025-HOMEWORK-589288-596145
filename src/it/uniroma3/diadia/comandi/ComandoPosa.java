package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	String nomeattrezzo=null;
	private IO console;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo attrezzo;
		if (nomeattrezzo!=null) {
			if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeattrezzo)==true) {
				attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeattrezzo);
				@SuppressWarnings("unused")
				boolean riuscito=partita.getStanzaCorrente().addAttrezzo(attrezzo);
				if (riuscito=false)
					console.mostraMessaggio("impossibile mettere nella stanza");
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeattrezzo);
				console.mostraMessaggio("lasciato nella stanza");
					
			}
			else console.mostraMessaggio("scrivi un attrezzo che hai in borsa!");
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
		return "posa";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return nomeattrezzo;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		console=io;
	}

}
