package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;

public class Ficha implements Serializable{
	private Bioma biomaIzq;
	private Bioma biomaDer;
	private Integer nro;
	
	public Ficha(Integer nro) {
		this.nro = nro;
		this.biomaIzq = Bioma.randomBioma();
		this.biomaDer = Bioma.randomBioma();
	}

	public Bioma getBiomaDer() {
		return biomaDer;
	}

	public Bioma getBiomaIzq() {
		return biomaIzq;
	}

	public Integer getNro() {
		return nro;
	}
	
	@Override
	public String toString() {
		return nro + ", " + biomaIzq + ", " + biomaDer;
	}
}
