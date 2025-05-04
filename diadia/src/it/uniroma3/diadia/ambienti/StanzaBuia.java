package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String AttrezzoLuminoso;
	
	public StanzaBuia(String nome,String AttrezzoLuminoso) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.AttrezzoLuminoso=AttrezzoLuminoso;
	}
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(AttrezzoLuminoso))
			return super.getDescrizione();
		else
			return "quì c'è buio pesto";
		
	}
	

}
