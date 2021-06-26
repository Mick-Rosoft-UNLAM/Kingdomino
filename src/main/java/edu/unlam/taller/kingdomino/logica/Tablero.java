package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tablero implements Serializable {

	private int puntaje = 0;
	private static final long serialVersionUID = 2384899891065337487L;
	private FichaBioma[][] tablero;
	
	public FichaBioma[][] getTablero() {
		return tablero;
	}

	public Tablero() {
		tablero = new FichaBioma[10][10];
		tablero[4][4] = FichaBioma.tablero();
	}
	
	public void colocarFicha(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		if(posicionValida(ficha, posBiomaIzq, posBiomaDer)) {			
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY()] = ficha.getBiomaIzq();
			tablero[posBiomaDer.getX()][posBiomaDer.getY()] = ficha.getBiomaDer();
			//System.out.println("Posición valida.");
		} else {
			//System.out.println("Posición no valida o descarta.");
		}
	}

	private boolean posicionValida(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		return posicionVacia(posBiomaIzq, posBiomaDer) && existeBiomaAdyacente(ficha, posBiomaIzq, posBiomaDer);
	}

	public boolean existeBiomaAdyacente(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		boolean pieza1Arriba = false;
		boolean pieza1Abajo = false;
		boolean pieza1Izq = false;
		boolean pieza1Der = false;

		boolean pieza2Arriba = false;
		boolean pieza2Abajo = false;
		boolean pieza2Izq = false;
		boolean pieza2Der = false;
		
		if(tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()] != null) {
			pieza1Arriba = tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1] != null) {
			pieza1Izq = tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()] != null) {
			pieza1Abajo = tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1] != null) {
			pieza1Der = tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1].name() == Bioma.CASTILLO.toString();
		}
		
		if(tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()] != null) {
			pieza2Arriba = tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1] != null) {
			pieza2Izq = tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()] != null) {
			pieza2Abajo = tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1] != null) {
			pieza2Der = tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1].name() == Bioma.CASTILLO.toString();
		}
		return pieza1Arriba || pieza1Abajo || pieza1Izq || pieza1Der || pieza2Arriba || pieza2Abajo || pieza2Izq || pieza2Der;
	}
	
	public boolean posicionVacia(Posicion posBiomaIzq, Posicion posBiomaDer) {
		return tablero[posBiomaIzq.getX()][posBiomaIzq.getY()] == null && tablero[posBiomaDer.getX()][posBiomaDer.getY()] == null;
	}
	
	public int getPuntuaje() {
		return puntaje;
	}
	
	
	
	public void mostrarTablero() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(tablero[i][j] + "\t\t");
			}
			System.out.println();
		}
	}
	

	public String obtenerBioma(Posicion pos, Tablero tab) {
		FichaBioma bioma;
		bioma = tab.tablero[pos.getX()][pos.getY()];
		return bioma.name();
	}
	
	List<FichaBioma> areaBioma = new ArrayList<FichaBioma>();
//	private Ficha chosenBioma;

	public void encontrarZonaAdyacentes(int x, int y) {
	
		if (tablero[x][y] != null)
		{
		if ((tablero[x][y].puntajeYaSumado())) {
			 

			} else {
				areaBioma.add(tablero[x][y]);
				tablero[x][y].setPuntajeSumado(true);
				if ((tablero[x + 1][y] != null && tablero[x + 1][y].name() == tablero[x][y].name()) && (x + 1 != 10) && !tablero[x + 1][y].puntajeYaSumado()) {
					encontrarZonaAdyacentes(x + 1, y);
				}

				if ((tablero[x - 1][y] != null && tablero[x - 1][y].name() == tablero[x][y].name()) && (x - 1 != -1) && !tablero[x - 1][y].puntajeYaSumado()) {
					encontrarZonaAdyacentes(x - 1, y);
				}

				if (tablero[x][y + 1] != null && tablero[x][y + 1].name() == tablero[x][y].name() && (y + 1 != 10) && !tablero[x][y + 1].puntajeYaSumado()) {
					encontrarZonaAdyacentes(x, y + 1);
				}

				if (tablero[x][y - 1] != null && tablero[x][y - 1].name() == tablero[x][y].name() && (y - 1 != -1) && !tablero[x][y - 1].puntajeYaSumado()) {
					encontrarZonaAdyacentes(x, y - 1);
				}
			}

		}

	}

	public void puntuarZona(int x, int y) {

		encontrarZonaAdyacentes(x, y);
		int cantCoronas = 0;
		for (int i = 0; i < areaBioma.size(); i++) {
			cantCoronas += areaBioma.get(i).getCantCoronas();
		}
		puntaje += (areaBioma.size() * cantCoronas);
		areaBioma = new ArrayList<FichaBioma>();

	}

	public int sumarPuntos() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				puntuarZona(j, i);
			}
		}
		
		return puntaje;
	}
}
	
