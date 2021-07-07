package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.edu.unlam.taller.kingdomino.client.Cliente;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeTerminarRonda.TerminarRonda;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VentanaPartida extends JPanel{
	private static final long serialVersionUID = 1233146965782175444L;
	
	private ComponenteTablero componenteTablero;
	private ComponenteRonda componenteRonda;
	private JLabel lblNewLabel;
	
	public VentanaPartida(Cliente cliente) throws IOException {
		setPreferredSize(new Dimension(1230, 600));
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		setLayout(null);
		componenteTablero = new ComponenteTablero();
		componenteTablero.setBounds(50, 50, 540, 500);
		add(componenteTablero);
		componenteRonda = new ComponenteRonda(cliente);
		componenteRonda.setBounds(640, 50, 540, 500);
		add(componenteRonda);
		
		lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(50, 11, 1130, 21);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel);
	}

	public void initRonda(Ronda ronda) throws IOException {
		lblNewLabel.setText("Es el turno del jugador " + ronda.getJugadorTurno().toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(getColorJugadorActual(ronda.getJugadorTurno().getRey()));
		componenteRonda.initRonda(ronda);
	}


	public void avanzarRonda(Ronda ronda) {
		lblNewLabel.setText("Es el turno del jugador " + ronda.getJugadorTurno().toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(getColorJugadorActual(ronda.getJugadorTurno().getRey()));
		componenteRonda.avanzarRonda(ronda);
	}

	private Color getColorJugadorActual(String rey) {
		switch(rey) {
		case "RED":
			return Color.RED;
		case "YELLOW":
			return Color.YELLOW;
		case "GREEN":
			return Color.GREEN;
		case "BLUE":
			return Color.BLUE;
		default:
			return null;
		}
	}

	public void terminarRonda(TerminarRonda terminarRonda) {
		lblNewLabel.setText("Es el turno del jugador " + terminarRonda.getRonda().getJugadorTurno().toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(getColorJugadorActual(terminarRonda.getRonda().getJugadorTurno().getRey()));
		componenteRonda.terminarRonda(terminarRonda);
	}
}
