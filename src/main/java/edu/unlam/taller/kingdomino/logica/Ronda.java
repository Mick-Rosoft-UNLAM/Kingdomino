package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Ronda implements Serializable {
	
	private List<Jugador> jugadores;
	private List<Ficha> fichas;

	public Ronda(List<Jugador> jugadores, List<Ficha> fichasParaTurno) {
		this.jugadores = jugadores;
		this.fichas = fichasParaTurno;
	}
	
	public static Ronda nuevaRonda(List<Jugador> jugadores, List<Ficha> fichas) {
		return new Ronda(jugadores, fichas);
	}

//	public static void nuevaRonda(List<Jugador> jugadores, List<Ficha> fichas) {
//		for (Jugador jugador : jugadores) {
//			if(jugador.getFichaActual() != null) {
//				Posicion posBiomaDer = new Posicion();
//				Posicion posBiomaIzq = new Posicion();
//				inputJugadorPosFicha(Arrays.asList(posBiomaIzq, posBiomaDer)); 
//				jugador.colocarFichaPreviaEnTablero(jugador.getFichaActual(), posBiomaIzq, posBiomaDer);
//			}
//			int nro = inputJugador();
//			jugador.elegirFicha(fichas, nro - 1);
//		}
//	}

	public static void inputJugadorPosFicha(List<Posicion> posiciones) {
		Scanner scanner = new Scanner(System.in);
		for (Posicion posicion : posiciones) {
			System.out.println("Elegir posición para Bioma:\nX: ");
			posicion.setX(scanner.nextInt());
			System.out.println("Y: ");
			posicion.setY(scanner.nextInt());		
		}
		scanner.close();
	}

	public static int inputJugador() {
		System.out.println("Elegir un nro de ficha: ");
		return new Scanner(System.in).nextInt();
	}

	public int getCantidadDeJugadores() {
		return jugadores.size();
	}

	public String getFichas() {
		return fichas.toString();
	}
}
