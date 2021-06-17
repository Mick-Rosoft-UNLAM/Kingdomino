package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.edu.unlam.taller.kingdomino.logica.Ficha;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Partida;

public class TestRonda {
    Partida p1;
    Jugador j1, j2, j3, j4;

    List<Ficha> fichas;

    @Before
    public void inicializacion() {
        p1 = new Partida();
        j1 = new Jugador("Federico");
        j2 = new Jugador("Tomas");
        j3 = new Jugador("Lucas");
        j4 = new Jugador("Joel");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        p1.generarMazo();
        fichas = p1.getFichasParaTurno();
    }

    @Test
    public void elegirPrimerFicha() {
        j1.elegirFicha(fichas, 0);
        assertEquals(fichas.get(0), j1.getFichaActual());
    }

    @Test
    public void elegirSegundaFicha() {
        j1.elegirFicha(fichas, 1);
        assertEquals(fichas.get(1), j1.getFichaActual());
    }

    @Test
    public void elegirTercerFicha() {
        j1.elegirFicha(fichas, 2);
        assertEquals(fichas.get(2), j1.getFichaActual());
    }

    @Test
    public void elegirCuartaFicha() {
        j1.elegirFicha(fichas, 3);
        assertEquals(fichas.get(3), j1.getFichaActual());
    }

}