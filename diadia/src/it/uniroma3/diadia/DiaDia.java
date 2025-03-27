package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private Partita partita;
	private IOConsole console;

	public  DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.console = console;
		
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
		//scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome()!=null) {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine();
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if(comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if(comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else
				console.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				console.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;
		}
		console.mostraMessaggio("Inserisci un comando! scegli tra vai aiuto e fine");
		console.mostraMessaggio("scegli tra: vai aiuto fine");
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		//console.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	
	
	private void prendi(String nomeattrezzo) {
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
	
	private void posa(String nomeattrezzo) {
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

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console= new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}