package main.java.edu.unlam.taller.kingdomino.entornografico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import main.java.edu.unlam.taller.kingdomino.client.Cliente;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;

public class VentanaCrearPartida extends JPanel {
	private static final long serialVersionUID = -4994895651039084347L;
	JTextField textFieldUser;
	JList<String> list;

	public void setJugadores(String jugadores) {
		list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -1100482181954703866L;
			String[] values = jugadores.split(",");
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
	}

	public VentanaCrearPartida(JPanel panelContainer, Jugador jugador, Cliente cliente) throws IOException {
		setLayout(null);
		setSize(500, 303);
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setTextFieldUser());
		add(setJButtonJugar(jugador, panelContainer, cliente));
		add(setJugadoresLabel());
		
		
		list = new JList<String>();
		list.setBounds(338, 110, 128, 108);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setPreferredSize(new Dimension(120, 140));
		add(list);
		
	}

	private JLabel setJugadoresLabel() {
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(350, 85, 110, 14);
		return lblJugadores;
	}

	private JButton setJButtonJugar(Jugador jugador, JPanel panelContainer, Cliente cliente) {
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(338, 233, 128, 30);
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.iniciarPartida();
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
