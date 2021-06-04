package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

public class App {
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelContainer = new JPanel();
	Jugador jugador = new Jugador(null);
	
	public App() throws IOException {
		init();
		setComponentes();
		frame.add(panelContainer);
		frame.pack();
		frame.setVisible(true);
	}

	private void setComponentes() throws IOException {
		panelContainer.add(new VentanaPrincipal(cardLayout, panelContainer), "1");
		panelContainer.add(new VentanaAgregarJugador(cardLayout, panelContainer, jugador), "2");
	}

	private void init() {
		panelContainer.setLayout(cardLayout);
		frame.setTitle("Kindomino");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(500, 303));
		frame.setSize(500, 303);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) throws IOException {
		new App();
	}
}
