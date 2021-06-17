package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.edu.unlam.taller.kingdomino.logica.Bioma;
import main.java.edu.unlam.taller.kingdomino.logica.Ficha;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Partida;
import main.java.edu.unlam.taller.kingdomino.logica.Posicion;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;
import main.java.edu.unlam.taller.kingdomino.logica.Tablero;

public class TestTablero {

	Partida p1;
	Jugador j1, j2;

	@Before
	public void Inicializacion() {
		p1 = new Partida();
		j1 = new Jugador("Nicolas");
		j2 = new Jugador("Gustavo");

		p1.agregarJugador(j1);
		p1.agregarJugador(j2);

		p1.generarMazo();
	}
	@Test
	public void verificarPosicionLibre() {
		List<Ficha> fichas = p1.getFichasParaTurno();
		j1.elegirFicha(fichas, 1);
		assertEquals(true, j1.getTablero().posicionVacia(new Posicion(5, 4), new Posicion(6, 4)));
	}
	@Test
	public void verificarCastilloCentro() {
		Tablero tab = new Tablero();
		assertEquals(Bioma.CASTILLO.toString(), tab.obtenerBioma(new Posicion(4, 4), j1.getTablero()));
	}

	@Test
	public void verificarPosicionOcupada() {
		List<Ficha> fichas = p1.getFichasParaTurno();
		j1.elegirFicha(fichas, 1);
		j1.colocarFichaPreviaEnTablero(j1.getFichaActual(), new Posicion(5, 4), new Posicion(6, 4));
		assertEquals(false, j1.getTablero().posicionVacia(new Posicion(5, 4), new Posicion(6, 4)));
	}

}
