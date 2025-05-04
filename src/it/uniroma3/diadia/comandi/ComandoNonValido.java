package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
private IO console;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		console.mostraMessaggio("Comando Sconosciuto");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "non valido";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		console=io;
	}

}
