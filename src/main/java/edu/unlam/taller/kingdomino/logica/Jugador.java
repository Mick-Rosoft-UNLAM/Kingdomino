package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.List;

public class Jugador implements Serializable{

	private static final long serialVersionUID = -8672140927927732000L;
	private Ficha fichaActual;
	private Tablero tablero;
	private String apodo;
	private String rey;
	
	public Jugador(String apodo) {
		this.rey = null;
		this.apodo = apodo;
		this.tablero = new Tablero();
	}

	public void elegirFicha(List<Ficha> fichasInicio, int n) {
		this.fichaActual = fichasInicio.get(n); 
	}

	public Ficha getFichaActual() {
		return fichaActual;
	}

	public void colocarFichaPreviaEnTablero(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		this.tablero.colocarFicha(ficha, posBiomaIzq, posBiomaDer);
	}
	
	@Override
	public String toString() {
		return apodo;
	}

	public void mostrarTablero(Jugador Jugador) {
		Jugador.tablero.mostrarTablero();
	}

	public void setName(String apodo) {
		this.apodo = apodo;
	}

	public String getName() {
		return apodo;
	}

	public String getRey() {
		return rey;
	}

	public void setRey(String rey) {
		this.rey = rey;
	}

}
