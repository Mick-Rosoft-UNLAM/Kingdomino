package main.java.edu.unlam.taller.kingdomino.logica;

import java.util.List;

public class Jugador {
	private Ficha fichaActual;
	private Tablero tablero;
	private String apodo;
	
	public Jugador(String apodo) {
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

}
