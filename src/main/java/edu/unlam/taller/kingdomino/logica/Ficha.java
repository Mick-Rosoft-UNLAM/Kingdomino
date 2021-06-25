package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.Random;

public class Ficha implements Serializable{
	private static final long serialVersionUID = -3103441741302596497L;
	
	private Bioma biomaIzq;
	private Bioma biomaDer;
	
	private int cantCoronasIzq;
	private int cantCoronasDer;
	
	private Integer nro;
	
	public Ficha(Integer nro) {
		this.nro = nro;
		this.biomaIzq = Bioma.randomBioma();
		this.biomaDer = Bioma.randomBioma();
		this.cantCoronasIzq = new Random().nextInt(3);
		this.cantCoronasDer = new Random().nextInt(3);
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
		return biomaIzq + "-" + cantCoronasIzq + "_" + biomaDer + "-" + cantCoronasDer;
	}
}
