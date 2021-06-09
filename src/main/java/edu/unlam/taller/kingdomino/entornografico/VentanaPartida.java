package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VentanaPartida extends JPanel{
	private static final long serialVersionUID = 1233146965782175444L;

	public VentanaPartida() throws IOException {
		setPreferredSize(new Dimension(1230, 600));
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(new GridLayout(1, 2, 50, 0));
		add(new TableroView());
		add(new TableroView());
	}
}
