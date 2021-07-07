package main.java.edu.unlam.taller.kingdomino.dto;

import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class MensajeNoIniciarPartida implements Mensaje {
	String mensaje;
	
	public MensajeNoIniciarPartida(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public Object procesar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMensaje() {
		return mensaje;
	}

}
