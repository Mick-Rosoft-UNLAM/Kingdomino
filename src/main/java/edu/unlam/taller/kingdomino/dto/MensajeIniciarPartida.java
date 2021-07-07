package main.java.edu.unlam.taller.kingdomino.dto;

import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class MensajeIniciarPartida implements Mensaje {
	Ronda ronda;
	
	public MensajeIniciarPartida(Ronda ronda) {
		this.ronda = ronda;
	}
	
	@Override
	public Object procesar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ronda getMensaje() {
		return ronda;
	}

}
