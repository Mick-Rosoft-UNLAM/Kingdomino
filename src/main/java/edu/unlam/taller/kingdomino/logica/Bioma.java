package main.java.edu.unlam.taller.kingdomino.logica;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Bioma implements Serializable{
	BOSQUE,
	MINA,
	LAGO,
	TRIGAL,
	PASTIZAL,
	CAMPO,
	CASTILLO;
	
	private Bioma() {}
	
	private static final List<Bioma> VALUES =
		    Collections.unmodifiableList(Arrays.asList(values()));
	
	public static Bioma randomBioma() {
		Bioma rand;
		do {
			rand  = VALUES.get(new Random().nextInt(VALUES.size()));
		} while(rand == Bioma.CASTILLO);
		return rand;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
	
}
