package main.java.edu.unlam.taller.kingdomino.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class CargadorImg {
	Map<String, Image> imagenes = new HashMap<>();
	String path = ".//src//img//bioma//";
	
	public CargadorImg() throws IOException {
		imagenes.put("BOSQUE-0", ImageIO.read(new File(path + "BOSQUE-0.png")));
		imagenes.put("BOSQUE-1", ImageIO.read(new File(path + "BOSQUE-1.png")));
		imagenes.put("BOSQUE-2", ImageIO.read(new File(path + "BOSQUE-2.png")));
		imagenes.put("LAGO-0", ImageIO.read(new File(path + "LAGO-0.png")));
		imagenes.put("LAGO-1" , ImageIO.read(new File(path + "LAGO-1.png")));
		imagenes.put("LAGO-2", ImageIO.read(new File(path + "LAGO-2.png")));
		imagenes.put("MINA-0" ,ImageIO.read(new File(path + "MINA-0.png")));
		imagenes.put("MINA-1" ,ImageIO.read(new File(path + "MINA-1.png")));
		imagenes.put("MINA-2" , ImageIO.read(new File(path + "MINA-2.png")));
		imagenes.put("TRIGAL-0" , ImageIO.read(new File(path + "TRIGAL-0.png")));
		imagenes.put("TRIGAL-1", ImageIO.read(new File(path + "TRIGAL-1.png")));
		imagenes.put("TRIGAL-2", ImageIO.read(new File(path + "TRIGAL-2.png")));
		imagenes.put("PASTIZAL-0" , ImageIO.read(new File(path + "PASTIZAL-0.png")));
		imagenes.put("PASTIZAL-1", ImageIO.read(new File(path + "PASTIZAL-1.png")));
		imagenes.put("PASTIZAL-2", ImageIO.read(new File(path + "PASTIZAL-2.png")));
		imagenes.put("CAMPO-0" , ImageIO.read(new File(path + "CAMPO-0.png")));
		imagenes.put("CAMPO-1", ImageIO.read(new File(path + "CAMPO-1.png")));
		imagenes.put("CAMPO-2", ImageIO.read(new File(path + "CAMPO-2.png")));
	}

	public Image getImg(String string) {
		return imagenes.get(string);
	}
}
