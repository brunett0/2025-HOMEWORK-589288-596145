package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoChiave;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoChiave=attrezzoChiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(direzioneBloccata)) {
			if (this.hasAttrezzo(attrezzoChiave)) {
				return super.getStanzaAdiacente(direzione);
			}
			else return this;
			}
		else return super.getStanzaAdiacente(direzione);
		}
	
	@Override
	public String toString() {
    	return  "\n" + super.toString() + "\n" + this.direzioneBloccata + " è bloccata, " + "cerca " + attrezzoChiave + " per aprire!"; 
    }
	@Override
	public String getDescrizione() {
		return this.toString();
	}
}
