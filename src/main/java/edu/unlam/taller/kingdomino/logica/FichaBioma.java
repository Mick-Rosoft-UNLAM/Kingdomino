package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.Random;

public class FichaBioma implements Serializable{
	private static final long serialVersionUID = -7374765539694523537L;
	
	private Bioma bioma;
	private int cantCoronas;
	private boolean puntoSumado = false;
	
	public FichaBioma() {
		this.setCantCoronas(new Random().nextInt(3));
		this.setBioma(Bioma.randomBioma());
	}
	
	private FichaBioma(Bioma bioma, int cantCoronas) {
		this.cantCoronas = cantCoronas;
		this.bioma = bioma;
	}

	public Bioma getBioma() {
		return bioma;
	}

	public void setBioma(Bioma bioma) {
		this.bioma = bioma;
	}

	public int getCantCoronas() {
		return cantCoronas;
	}

	public void setCantCoronas(int cantCoronas) {
		this.cantCoronas = cantCoronas;
	}

	public static FichaBioma tablero() {
		return new FichaBioma(Bioma.CASTILLO, 0);
	}

	public String name() {
		return bioma.name();
	}
	
	public boolean puntajeYaSumado() {
        return puntoSumado;
    }
    public void setPuntajeSumado(boolean puntoSumado) {
        this.puntoSumado = puntoSumado;
    }
    
    @Override
    public String toString() {
    	return bioma.name() + "-" + cantCoronas;
    }
}
