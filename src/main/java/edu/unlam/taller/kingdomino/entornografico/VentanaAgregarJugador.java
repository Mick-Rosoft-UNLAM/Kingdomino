package main.java.edu.unlam.taller.kingdomino.entornografico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarJugador extends JPanel {
	private static final long serialVersionUID = -2190704995900735227L;
	JTextField textFieldUser;

	public VentanaAgregarJugador(CardLayout cardLayout, JPanel panelContainer, Jugador jugador) throws IOException {
		setLayout(null);
		setSize(500, 303);
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setTextFieldUser());
		add(setJButtonUnirse(jugador));
		add(setJButtonCrearPartida(jugador));
	}

	private JButton setJButtonCrearPartida(Jugador jugador) {
		JButton btnCrearPartida = new JButton("Crear Partida");
		btnCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombreDeUsuarioValido()) {
					jugador.setName(textFieldUser.getText());
				} else {					
					textFieldUser.setBorder(new LineBorder(Color.RED));
					JOptionPane.showMessageDialog(null, "El nombre de usuario es inválido.");
				}
			}
		});
		btnCrearPartida.setBounds(338, 110, 128, 30);
		return btnCrearPartida;
	}

	private JButton setJButtonUnirse(Jugador jugador) {
		JButton btnUnirse = new JButton("Unirse a Partida");
		btnUnirse.setBounds(339, 183, 128, 30);
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombreDeUsuarioValido()) {
					jugador.setName(textFieldUser.getText());
				} else {					
					textFieldUser.setBorder(new LineBorder(Color.RED));
					JOptionPane.showMessageDialog(null, "El nombre de usuario es inválido.");
				}
			}

			
		});
		return btnUnirse;
	}

	private JTextField setTextFieldUser() {
		textFieldUser = new JTextField();
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setBounds(345, 48, 117, 20);
		textFieldUser.setColumns(10);

		textFieldUser.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validarNombreDeUsuario();

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validarNombreDeUsuario();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			
			public void validarNombreDeUsuario() {
				if(!textFieldUser.getText().equals("") && textFieldUser.getText().length() < 8) {
					textFieldUser.setBorder(new LineBorder(Color.GREEN));
				} else {
					textFieldUser.setBorder(new LineBorder(Color.RED));
				}
			}

		});
		return textFieldUser;
	}

	private JLabel setIgresarJugadorLabel() {
		JLabel lblIngresarJugador = new JLabel("Ingresar usuario:");
		lblIngresarJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarJugador.setBounds(350, 23, 110, 14);
		return lblIngresarJugador;
	}

	private JLabel setImagen() throws IOException {
		BufferedImage imgKingDomino = ImageIO.read(new File(".//src//img//cover.png"));
		JLabel lblImgKingDomino = new JLabel(new ImageIcon(imgKingDomino));
		lblImgKingDomino.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgKingDomino.setBounds(0, 0, 300, 303);
		return lblImgKingDomino;
	}
	
	private boolean nombreDeUsuarioValido() {
		return !textFieldUser.getText().equals("") && textFieldUser.getText().length() < 8;
	}
}
