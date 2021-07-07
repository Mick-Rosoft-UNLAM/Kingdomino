package main.java.edu.unlam.taller.kingdomino.dto;

import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class MensajeAvanzarRonda implements Mensaje {
	private Ronda ronda;
	
	public MensajeAvanzarRonda(Ronda ronda) {
		this.ronda = ronda;
	}
	
	@Override
	public Object procesar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getMensaje() {
		return ronda;
	}

}
