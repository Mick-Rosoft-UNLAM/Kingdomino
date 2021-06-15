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
import javax.swing.JScrollBar;
import javax.swing.JList;

public class VentanaUnirse extends JPanel {
	private static final long serialVersionUID = -4994895651039084347L;

	public VentanaUnirse(JPanel panelContainer, Jugador jugador) throws IOException {
		setLayout(null);
		setSize(500, 303);
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setJButtonJugar(jugador));
		
		JPanel panel = new JPanel();
		panel.setBounds(338, 52, 152, 170);
		add(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(135, 0, 17, 170);
		panel.add(scrollBar);
		
		JList list = new JList();
		list.setBounds(10, 157, 102, -94);
		panel.add(list);
	}


	private JButton setJButtonJugar(Jugador jugador) {
		JButton btnJugar = new JButton("UNIRSE");
		btnJugar.setBounds(338, 233, 128, 30);
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		return btnJugar;
	}


	private JLabel setIgresarJugadorLabel() {
		JLabel lblIngresarJugador = new JLabel("Partidas Activas:");
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
