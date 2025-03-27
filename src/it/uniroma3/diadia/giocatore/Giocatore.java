package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa=new Borsa();
	
	public Giocatore() {
		cfu=CFU_INIZIALI;
		
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	
}
