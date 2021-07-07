package main.java.edu.unlam.taller.kingdomino.dto;

import java.io.Serializable;

import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class MensajeTerminarRonda implements Mensaje {
	private static final long serialVersionUID = -5540966840985092700L;
	
	private TerminarRonda terminarRonda;
	
	public MensajeTerminarRonda(Ronda rondaAnterior, Ronda ronda) {
		this.terminarRonda = new TerminarRonda(rondaAnterior, ronda);
	}

	@Override
	public Object procesar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getMensaje() {
		return terminarRonda;
	}
	
	public class TerminarRonda implements Serializable{
		private static final long serialVersionUID = -7037251748061112818L;
		
		private Ronda rondaAnterior;
		private Ronda ronda;
		
		private TerminarRonda(Ronda rondaAnterior, Ronda ronda) {
			this.rondaAnterior = rondaAnterior;
			this.ronda = ronda;
		}
		
		public Ronda getRondaAnterior() {
			return rondaAnterior;
		}
		public void setRondaAnterior(Ronda rondaAnterior) {
			this.rondaAnterior = rondaAnterior;
		}
		public Ronda getRonda() {
			return ronda;
		}
		public void setRonda(Ronda ronda) {
			this.ronda = ronda;
		}
	}
}
