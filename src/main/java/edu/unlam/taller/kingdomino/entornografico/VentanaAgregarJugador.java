package main.java.edu.unlam.taller.kingdomino.entornografico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarJugador extends JPanel {
	private static final long serialVersionUID = -2190704995900735227L;
	private JTextField textFieldUser;

	public VentanaAgregarJugador(CardLayout cardLayout, JPanel panelContainer, Jugador jugador) throws IOException {
		setLayout(null);
		setSize(500, 303);
		JLabel lblIngresarJugador = new JLabel("Ingresar usuario:");
		lblIngresarJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarJugador.setBounds(350, 23, 110, 14);
		add(lblIngresarJugador);
		add(setImagen());
		
		textFieldUser = new JTextField();
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setBounds(345, 48, 117, 20);
		textFieldUser.setColumns(10);
		textFieldUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(!textFieldUser.getText().equals("")) {
						jugador.setName(textFieldUser.getText());
						textFieldUser.setBorder(new LineBorder(Color.GREEN));
					} else {
						textFieldUser.setBorder(new LineBorder(Color.RED));
					}
				} else {
					textFieldUser.setBorder(new LineBorder(Color.BLACK));
				}
			}
		});
		add(textFieldUser);
		
		JButton btnUnirse = new JButton("Unirse a Partida");
		btnUnirse.setBounds(339, 183, 128, 30);
		add(btnUnirse);
		
		JButton btnCrearPartida = new JButton("Crear Partida");
		btnCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearPartida.setBounds(338, 110, 128, 30);
		add(btnCrearPartida);
	}

	private JLabel setImagen() throws IOException {
		BufferedImage imgKingDomino = ImageIO.read(new File(".//src//img//cover.png"));
		JLabel lblImgKingDomino = new JLabel(new ImageIcon(imgKingDomino));
		lblImgKingDomino.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgKingDomino.setBounds(0, 0, 300, 303);
		return lblImgKingDomino;
	}
}
