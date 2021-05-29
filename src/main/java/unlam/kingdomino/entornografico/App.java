package main.java.unlam.kingdomino.entornografico;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JFrame frame = new JFrame();
	JPanel panelContainer = new JPanel();
	
	public App() throws IOException {
		panelContainer.setLayout(cardLayout);
		frame.setTitle("Kindomino");
		frame.setSize(480, 343);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		panelContainer.add(new VentanaPrincipal(cardLayout, panelContainer), "1");
		panelContainer.add(new VentanaAgregarJugador(), "2");
		frame.add(panelContainer);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		new App();
	}
}
