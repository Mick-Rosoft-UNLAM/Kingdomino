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
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaCrearPartida extends JPanel {
	private static final long serialVersionUID = -4994895651039084347L;
	JTextField textFieldUser;
	private JTextField textField;

	public VentanaCrearPartida(JPanel panelContainer, Jugador jugador) throws IOException {
		setLayout(null);
		setSize(500, 303);
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setTextFieldUser());
		add(setJButtonJugar(jugador));
		add(setJugadoresLabel());
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(345, 109, 117, 99);
		add(textField);
	}

	private JLabel setJugadoresLabel() {
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(350, 85, 110, 14);
		return lblJugadores;
	}

	private JButton setJButtonJugar(Jugador jugador) {
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(338, 233, 128, 30);
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		return btnJugar;
	}

	private JTextField setTextFieldUser() {
		textFieldUser = new JTextField();
		textFieldUser.setEnabled(false);
		textFieldUser.setEditable(false);
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
		JLabel lblIngresarJugador = new JLabel("C\u00F3digo:");
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
}
