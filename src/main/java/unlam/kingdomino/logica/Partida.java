package main.java.unlam.kingdomino.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Partida {
	private List<Ficha> mazo;
	private List<Jugador> jugadores;
	private boolean primerRonda = true;
	
	public Partida() {
		this.jugadores = new ArrayList<>();
	}
	
	public void iniciarPartida() {
		if(cantJugadoresOk()) {
			generarMazo();
			while(!mazo.isEmpty()) {
				ordenarJugadores();
				Ronda.nuevaRonda(jugadores, getFichasParaTurno());
			}
			finalizarPartida();
		} else
			System.out.println("Cantidad de jugadores no valida.");
	}
	
	public void ordenarJugadores() {
		if(primerRonda) {
			Collections.shuffle(jugadores);
			primerRonda = false;
		} else {
			Collections.sort(jugadores, (j1, j2) -> {
				return j1.getFichaActual().getNro().compareTo(j2.getFichaActual().getNro());
			});			
		}
	}

	public boolean cantJugadoresOk() {
		return jugadores.size() >= 2 && jugadores.size() <= 4;
	}

	public void agregarJugador(Jugador jugador) {
		if(jugadores.size() < 4) {
			jugadores.add(jugador);
		}
	}

	private void finalizarPartida() {
		this.calcularGanador();
	}

	private Jugador calcularGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ficha> getFichasParaTurno() {
		List<Ficha> fichas = new ArrayList<>();
		for(int i = 0; i < jugadores.size(); i++) {
			fichas.add(mazo.remove(new Random().nextInt(mazo.size())));
		}
		Collections.sort(fichas, (f1, f2) -> {
			return f1.getNro().compareTo(f2.getNro());
		});
		return fichas;
	}

	public void generarMazo() {
		this.mazo = new ArrayList<>();
		for(int i = 0; i < jugadores.size() * 12; i++) {
			mazo.add(new Ficha(i));
		}
	}

	public String getJugadores() {
		return this.jugadores.toString();
	}
	
	public void setPrimeraRonda(boolean primeraRonda) {
		this.primerRonda = primeraRonda;
	}
	
	public List<Ficha> getMazo() {
		return this.mazo;
	}
	
	public void setMazo() {
		
	}
	
	public int getCantDeJugadores() {
		return jugadores.size();
	}
}
