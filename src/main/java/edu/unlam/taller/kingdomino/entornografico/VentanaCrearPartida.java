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
import main.java.edu.unlam.taller.kingdomino.utils.CargadorImg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class VentanaCrearPartida extends JPanel {
	private static final long serialVersionUID = -4994895651039084347L;
	JTextField textFieldUser;
	JList<String> list;
	
	JButton btnReyRojo;
	JButton btnReyVerde;
	JButton btnReyAmarillo;
	JButton btnReyAzul;

	CargadorImg cargadorImg;

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

	public VentanaCrearPartida(JPanel panelContainer, Cliente cliente) throws IOException {
		cargadorImg = CargadorImg.getInstance();
		
		setLayout(null);
		setSize(500, 303);
		add(setIgresarJugadorLabel());
		add(setImagen());
		add(setTextFieldUser());
		add(setJButtonJugar(panelContainer, cliente));
		add(setJugadoresLabel());
		
		btnReyRojo = new JButton();
		btnReyRojo.setBorder(new LineBorder(Color.RED)); 
		btnReyRojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.elegirRey("ROJO");
			}
		});
		btnReyRojo.setBounds(337, 251, 25, 25);
		btnReyRojo.setIcon(new ImageIcon((cargadorImg.getImg("ROJO").getImage()).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		add(btnReyRojo);
		
		btnReyAzul = new JButton("");
		btnReyAzul.setBounds(371, 251, 25, 25);
		btnReyAzul.setBorder(new LineBorder(Color.BLUE)); 
		btnReyAzul.setIcon(new ImageIcon((cargadorImg.getImg("AZUL").getImage()).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnReyAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.elegirRey("AZUL");
			}
		});
		add(btnReyAzul);
		
		btnReyAmarillo = new JButton("");
		btnReyAmarillo.setBounds(439, 251, 25, 25);
		btnReyAmarillo.setBorder(new LineBorder(Color.YELLOW)); 
		btnReyAmarillo.setIcon(new ImageIcon((cargadorImg.getImg("AMARILLO").getImage()).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnReyAmarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.elegirRey("AMARILLO");
			}
		});
		add(btnReyAmarillo);
		
		btnReyVerde = new JButton("");
		btnReyVerde.setBounds(405, 251, 25, 25);
		btnReyVerde.setIcon(new ImageIcon((cargadorImg.getImg("VERDE").getImage()).getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnReyVerde.setBorder(new LineBorder(Color.GREEN));
		btnReyVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.elegirRey("VERDE");
			}
		});
		add(btnReyVerde);
		
		JLabel lblElegirRey = new JLabel("Elegir Rey:");
		lblElegirRey.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegirRey.setBounds(347, 229, 110, 14);
		add(lblElegirRey);
		
		list = new JList<String>();
		list.setBounds(338, 84, 128, 89);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setPreferredSize(new Dimension(120, 140));
		add(list);
		
	}

	private JLabel setJugadoresLabel() {
		JLabel lblJugadores = new JLabel("Jugadores:");
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(350, 65, 110, 14);
		return lblJugadores;
	}

	private JButton setJButtonJugar(JPanel panelContainer, Cliente cliente) {
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(338, 187, 128, 30);
		
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
		textFieldUser.setBounds(345, 33, 117, 20);
		textFieldUser.setColumns(10);
		return textFieldUser;
	}

	private JLabel setIgresarJugadorLabel() {
		JLabel lblIngresarJugador = new JLabel("C\u00F3digo:");
		lblIngresarJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarJugador.setBounds(350, 15, 110, 14);
		return lblIngresarJugador;
	}

	private JLabel setImagen() throws IOException {
		BufferedImage imgKingDomino = ImageIO.read(new File(".//src//img//cover.png"));
		JLabel lblImgKingDomino = new JLabel(new ImageIcon(imgKingDomino));
		lblImgKingDomino.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgKingDomino.setBounds(0, 0, 300, 303);
		return lblImgKingDomino;
	}

	public JButton getBtnRey(String rey) {
		switch(rey) {
		case "ROJO":
			return btnReyRojo;
		case "VERDE":
			return btnReyVerde;
		case "AMARILLO":
			return btnReyAmarillo;
		case "AZUL":
			return btnReyAzul;
		default:
			return null;
		}
	}
}
