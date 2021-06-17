package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Partida;

public class TestPartida {
    Partida p1;
    Jugador j1, j2, j3, j4;

    @Before
    public void inicializacion() {
        p1 = new Partida();
        j1 = new Jugador("Federico");
        j2 = new Jugador("Tomas");
        j3 = new Jugador("Lucas");
        j4 = new Jugador("Joel");
    }

    @Test
    public void iniciarPartidaDosJugadores() {
    	p1.agregarJugador(j1);
    	p1.agregarJugador(j2);
        assertEquals(true, p1.cantJugadoresOk());
    }

    @Test
    public void iniciarPartidaTresJugadores() {
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        assertEquals(true, p1.cantJugadoresOk());
    }

    @Test
    public void iniciarPartidaCuatroJugadores() {
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        assertEquals(true, p1.cantJugadoresOk());
    }

    @Test
    public void noIniciarPartida() {
        p1.agregarJugador(j1);
        assertEquals(false, p1.cantJugadoresOk());
    }

    @Test
    public void generarMazoDosJugadores() {
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);

        p1.generarMazo();
        assertEquals(24, p1.getMazo().size());
    }
    @Test
    public void generarMazoTresJugadores() {
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.generarMazo();
        assertEquals(36, p1.getMazo().size());
    }
    @Test
    public void generarMazoCuatroJugadores() {
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        p1.generarMazo();
        assertEquals(48, p1.getMazo().size());
    }
}


