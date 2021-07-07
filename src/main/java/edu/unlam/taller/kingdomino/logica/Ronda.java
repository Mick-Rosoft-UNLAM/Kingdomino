package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Ronda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037792517835739368L;
	private List<Jugador> jugadores;
	private List<Ficha> fichas;
	private int turno;
	private Ficha fichaTurnoAnterior;

	public Ronda(List<Jugador> jugadores, List<Ficha> fichasParaTurno) {
		this.turno = 0;
		this.jugadores = jugadores;
		this.fichas = fichasParaTurno;
	}

	public int getCantidadDeJugadores() {
		return jugadores.size();
	}

	public String getFichas() {
		return fichas.toString();
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Jugador getJugadorTurno() {
		return jugadores.size() == turno ? jugadores.get(turno - 1) : jugadores.get(turno);
	}

	public int getNroFicha(int i) {
		return fichas.get(i).getNro();
	}

	public Ronda avanzarRonda(int fichaElegida) {
		jugadores.get(turno).elegirFicha(fichas, fichaElegida);
		fichaTurnoAnterior = fichas.get(fichaElegida);
		turno++;
		return this;
	}

	public int getNroFichaTurnoAnterior() {
		return fichas.indexOf(fichaTurnoAnterior);
	}

	public Jugador getJugadorTurnoAnterior() {
		return jugadores.get(turno - 1);
	}

	public boolean ultimoTurno() {
		return jugadores.size() == turno + 1;
	}

	public void terminarRonda(int fichaElegida) {
		avanzarRonda(fichaElegida);
	}
}
