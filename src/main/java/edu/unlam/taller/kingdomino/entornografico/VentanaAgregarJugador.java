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

import main.java.edu.unlam.taller.kingdomino.client.Cliente;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.utils.CargadorImg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAgregarJugador extends JPanel {
	private static final long serialVersionUID = -2190704995900735227L;
	JTextField txtFldUsuario;
	JButton btnCrearPartida;
	JButton btnUnirse;
	JLabel lblIngresarJugador;
	JLabel lblImgKD;
	private CargadorImg cargadorImg;

	public VentanaAgregarJugador(JPanel panelContainer, Jugador jugador, Cliente cliente) throws IOException {
		cargadorImg = CargadorImg.getInstance();
		
		setLayout(null);
		setSize(500, 303);
		add(initLblIgresarJugador());
		add(cargarImagenKD());
		add(initTxtFldUsuario());
		add(initBtnUnirse(jugador, panelContainer));
		add(initBtnCrearPartida(jugador, panelContainer, cliente));
		
		JButton btnReyRojo = new JButton("");
		btnReyRojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cliente.elegirRey("ROJO");
			}
		});
		btnReyRojo.setBounds(337, 251, 25, 25);
		btnReyRojo.setIcon(new ImageIcon(cargadorImg.getImg("ROJO").getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		add(btnReyRojo);
		
		JButton btnReyAzul = new JButton("");
		btnReyAzul.setBounds(371, 251, 25, 25);
		btnReyAzul.setIcon(new ImageIcon(cargadorImg.getImg("AZUL").getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		add(btnReyAzul);
		
		JButton btnReyAmarillo = new JButton("");
		btnReyAmarillo.setBounds(439, 251, 25, 25);
		btnReyAmarillo.setIcon(new ImageIcon(cargadorImg.getImg("AMARILLO").getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		add(btnReyAmarillo);
		
		JButton btnReyVerde = new JButton("");
		btnReyVerde.setBounds(405, 251, 25, 25);
		btnReyVerde.setIcon(new ImageIcon(cargadorImg.getImg("VERDE").getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		add(btnReyVerde);
		
		JLabel lblElegirRey = new JLabel("Elegir Rey:");
		lblElegirRey.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegirRey.setBounds(347, 229, 110, 14);
		add(lblElegirRey);
	}

	private JButton initBtnCrearPartida(Jugador jugador, JPanel panelContainer, Cliente cliente) {
		btnCrearPartida = new JButton("Crear/Unirse");
		btnCrearPartida.setBounds(338, 110, 128, 30);
		
		btnCrearPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombreDeUsuarioValido()) {
					jugador.setName(txtFldUsuario.getText());
					cliente.startClient();
					cliente.agregarJugador(jugador.getName());					
				} else {					
					txtFldUsuario.setBorder(new LineBorder(Color.RED));
					JOptionPane.showMessageDialog(null, "El nombre de usuario es inv�lido.");
				}
			}
		});
		
		return btnCrearPartida;
	}

	private JButton initBtnUnirse(Jugador jugador, JPanel panelContainer) {
		btnUnirse = new JButton("Unirse a Partida");
		btnUnirse.setBounds(339, 183, 128, 30);
		btnUnirse.setEnabled(false);
		
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombreDeUsuarioValido()) {
					jugador.setName(txtFldUsuario.getText());
					((CardLayout) panelContainer.getLayout()).show(panelContainer, "5");;
				} else {					
					txtFldUsuario.setBorder(new LineBorder(Color.RED));
					JOptionPane.showMessageDialog(null, "El nombre de usuario es inv�lido.");
				}
			}
		});
		
		return btnUnirse;
	}

	private JTextField initTxtFldUsuario() {
		txtFldUsuario = new JTextField();
		txtFldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtFldUsuario.setBounds(345, 48, 117, 20);
		txtFldUsuario.setColumns(10);
		txtFldUsuario.setBorder(new LineBorder(Color.RED));

		txtFldUsuario.getDocument().addDocumentListener(new DocumentListener() {

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
				if(!txtFldUsuario.getText().equals("") && txtFldUsuario.getText().length() < 8) {
					txtFldUsuario.setBorder(new LineBorder(Color.GREEN));
				} else {
					txtFldUsuario.setBorder(new LineBorder(Color.RED));
				}
			}

		});
		
		return txtFldUsuario;
	}

	private JLabel initLblIgresarJugador() {
		lblIngresarJugador = new JLabel("Ingresar usuario:");
		lblIngresarJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarJugador.setBounds(350, 23, 110, 14);
		return lblIngresarJugador;
	}

	private JLabel cargarImagenKD() throws IOException {
		BufferedImage imgKDBuff = ImageIO.read(new File(".//src//img//cover.png"));
		lblImgKD = new JLabel(new ImageIcon(imgKDBuff));
		lblImgKD.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgKD.setBounds(0, 0, 300, 303);
		return lblImgKD;
	}
	
	private boolean nombreDeUsuarioValido() {
		return !txtFldUsuario.getText().equals("") && txtFldUsuario.getText().length() < 8;
	}
}
