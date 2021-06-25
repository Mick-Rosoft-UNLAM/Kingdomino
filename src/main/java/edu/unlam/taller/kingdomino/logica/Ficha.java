package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.Random;

public class Ficha implements Serializable{
	private static final long serialVersionUID = -3103441741302596497L;
	
	private FichaBioma biomaIzq;
	private FichaBioma biomaDer;
	
	
	private Integer nro;
	
	public Ficha(Integer nro) {
		this.nro = nro;
		this.biomaIzq = new FichaBioma();
		this.biomaDer = new FichaBioma();
	}

	public FichaBioma getBiomaDer() {
		return biomaDer;
	}

	public FichaBioma getBiomaIzq() {
		return biomaIzq;
	}

	public Integer getNro() {
		return nro;
	}
	
	@Override
	public String toString() {
		return biomaIzq  + "_" + biomaDer;
	}
}
