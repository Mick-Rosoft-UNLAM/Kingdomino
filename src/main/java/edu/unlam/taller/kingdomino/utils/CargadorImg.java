package main.java.edu.unlam.taller.kingdomino.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CargadorImg {
	private static CargadorImg instance = new CargadorImg();
	
	private Map<String, ImageIcon> imagenes = new HashMap<>();
	private String pathBioma = ".//src//img//bioma//";
	private String pathRey = ".//src//img//rey//";
	
	private CargadorImg() {
		try {
			imagenes.put("BOSQUE-0", new ImageIcon(ImageIO.read(new File(pathBioma + "BOSQUE-0.png"))));
			imagenes.put("BOSQUE-1", new ImageIcon(ImageIO.read(new File(pathBioma + "BOSQUE-1.png"))));
			imagenes.put("BOSQUE-2", new ImageIcon(ImageIO.read(new File(pathBioma + "BOSQUE-2.png"))));
			imagenes.put("LAGO-0", new ImageIcon(ImageIO.read(new File(pathBioma + "LAGO-0.png"))));
			imagenes.put("LAGO-1" , new ImageIcon(ImageIO.read(new File(pathBioma + "LAGO-1.png"))));
			imagenes.put("LAGO-2", new ImageIcon(ImageIO.read(new File(pathBioma + "LAGO-2.png"))));
			imagenes.put("MINA-0" ,new ImageIcon(ImageIO.read(new File(pathBioma + "MINA-0.png"))));
			imagenes.put("MINA-1" ,new ImageIcon(ImageIO.read(new File(pathBioma + "MINA-1.png"))));
			imagenes.put("MINA-2" , new ImageIcon(ImageIO.read(new File(pathBioma + "MINA-2.png"))));
			imagenes.put("TRIGAL-0" , new ImageIcon(ImageIO.read(new File(pathBioma + "TRIGAL-0.png"))));
			imagenes.put("TRIGAL-1", new ImageIcon(ImageIO.read(new File(pathBioma + "TRIGAL-1.png"))));
			imagenes.put("TRIGAL-2", new ImageIcon(ImageIO.read(new File(pathBioma + "TRIGAL-2.png"))));
			imagenes.put("PASTIZAL-0" , new ImageIcon(ImageIO.read(new File(pathBioma + "PASTIZAL-0.png"))));
			imagenes.put("PASTIZAL-1", new ImageIcon(ImageIO.read(new File(pathBioma + "PASTIZAL-1.png"))));
			imagenes.put("PASTIZAL-2", new ImageIcon(ImageIO.read(new File(pathBioma + "PASTIZAL-2.png"))));
			imagenes.put("CAMPO-0" , new ImageIcon(ImageIO.read(new File(pathBioma + "CAMPO-0.png"))));
			imagenes.put("CAMPO-1", new ImageIcon(ImageIO.read(new File(pathBioma + "CAMPO-1.png"))));
			imagenes.put("CAMPO-2", new ImageIcon(ImageIO.read(new File(pathBioma + "CAMPO-2.png"))));
			imagenes.put("AMARILLO", new ImageIcon(ImageIO.read(new File(pathRey + "AMARILLO.png"))));
			imagenes.put("AZUL", new ImageIcon(ImageIO.read(new File(pathRey + "AZUL.png"))));
			imagenes.put("VERDE", new ImageIcon(ImageIO.read(new File(pathRey + "VERDE.png"))));
			imagenes.put("ROJO", new ImageIcon(ImageIO.read(new File(pathRey + "ROJO.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static CargadorImg getInstance() {
		return instance;
	}

	public ImageIcon getImg(String string) {
		return imagenes.get(string);
	}
}
