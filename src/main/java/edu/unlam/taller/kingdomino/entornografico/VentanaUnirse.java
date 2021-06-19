package main.java.edu.unlam.taller.kingdomino.entornografico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;

public class VentanaUnirse extends JPanel {
	private static final long serialVersionUID = -4994895651039084347L;

	public VentanaUnirse(JPanel panelContainer, Jugador jugador) throws IOException {
		setLayout(null);
		setSize(500, 303);
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < 15; i++) {
			model.addElement("Element " + i);
		}
		
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setJButtonJugar(jugador));
		
		JPanel panel = new JPanel();
		panel.setBounds(338, 64, 128, 154);
		add(panel);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
		this.setVisible(true);
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
