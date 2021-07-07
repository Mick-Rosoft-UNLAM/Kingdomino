package main.java.edu.unlam.taller.kingdomino.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CargadorImg {
	//private static CargadorImg instance = new CargadorImg();
	
	private Map<String, ImageIcon> imagenes = new HashMap<>();
	private String pathBioma = "../../../../../../../img/bioma/";
	private String pathRey = "../../../../../../../img/rey/";
	private String path = 	 "../../../../../../../img/";
	
	public CargadorImg() {
		imagenes.put("BOSQUE-0", new ImageIcon(getClass().getResource(pathBioma + "BOSQUE-0.png")));
		imagenes.put("BOSQUE-1", new ImageIcon(getClass().getResource(pathBioma + "BOSQUE-1.png")));
		imagenes.put("BOSQUE-2", new ImageIcon(getClass().getResource(pathBioma + "BOSQUE-2.png")));
		imagenes.put("LAGO-0", new ImageIcon(getClass().getResource(pathBioma + "LAGO-0.png")));
		imagenes.put("LAGO-1" , new ImageIcon(getClass().getResource(pathBioma + "LAGO-1.png")));
		imagenes.put("LAGO-2", new ImageIcon(getClass().getResource(pathBioma + "LAGO-2.png")));
		imagenes.put("MINA-0" , new ImageIcon(getClass().getResource(pathBioma + "MINA-0.png")));
		imagenes.put("MINA-1" , new ImageIcon(getClass().getResource(pathBioma + "MINA-1.png")));
		imagenes.put("MINA-2" , new ImageIcon(getClass().getResource(pathBioma + "MINA-2.png")));
		imagenes.put("TRIGAL-0" , new ImageIcon(getClass().getResource(pathBioma + "TRIGAL-0.png")));
		imagenes.put("TRIGAL-1", new ImageIcon(getClass().getResource(pathBioma + "TRIGAL-1.png")));
		imagenes.put("TRIGAL-2", new ImageIcon(getClass().getResource(pathBioma + "TRIGAL-2.png")));
		imagenes.put("PASTIZAL-0" , new ImageIcon(getClass().getResource(pathBioma + "PASTIZAL-0.png")));
		imagenes.put("PASTIZAL-1", new ImageIcon(getClass().getResource(pathBioma + "PASTIZAL-1.png")));
		imagenes.put("PASTIZAL-2", new ImageIcon(getClass().getResource(pathBioma + "PASTIZAL-2.png")));
		imagenes.put("CAMPO-0" , new ImageIcon(getClass().getResource(pathBioma + "CAMPO-0.png")));
		imagenes.put("CAMPO-1", new ImageIcon(getClass().getResource(pathBioma + "CAMPO-1.png")));
		imagenes.put("CAMPO-2", new ImageIcon(getClass().getResource(pathBioma + "CAMPO-2.png")));
		imagenes.put("YELLOW", new ImageIcon(getClass().getResource(pathRey + "AMARILLO.png")));
		imagenes.put("BLUE", new ImageIcon(getClass().getResource(pathRey + "AZUL.png")));
		imagenes.put("GREEN", new ImageIcon(getClass().getResource(pathRey + "VERDE.png")));
		imagenes.put("RED", new ImageIcon(getClass().getResource(pathRey + "ROJO.png")));
		imagenes.put("VACIO", new ImageIcon(getClass().getResource(path + "VACIO.png")));
		imagenes.put("VACIO_SELECCIONADO", new ImageIcon(getClass().getResource(path + "VACIO_SELECCIONADO.png")));
		imagenes.put("CASTILLO", new ImageIcon(getClass().getResource(path + "CASTILLO.png")));
	}
	
//	public static CargadorImg getInstance() {
//		return instance;
//	}

	public ImageIcon getImg(String string) {
		return imagenes.get(string);
	}
}
