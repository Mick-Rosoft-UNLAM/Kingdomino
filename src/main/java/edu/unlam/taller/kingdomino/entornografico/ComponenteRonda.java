package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class ComponenteRonda extends JPanel {

	private static final long serialVersionUID = 823404469605528280L;
	private JTextField txtFldPosIzqFil;
	private JTextField txtFldPosIzqCol;
	private JTextField txtFldPosDerFil;
	private JTextField txtFldPosDerCol;
	private JPanel panel_1; 
	private JPanel panelRonda;

	public ComponenteRonda() {
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(540, 540));
		setLayout(null);
	
		
		panelRonda = new JPanel();
		panelRonda.setBackground(Color.LIGHT_GRAY);
		panelRonda.setBounds(34, 36, 227, 320);
		add(panelRonda);

		panel_1 = new JPanel();
		panel_1.setBounds(34, 385, 468, 98);
		add(panel_1);
		panel_1.setLayout(null);

		txtFldPosIzqCol = new JTextField();
		txtFldPosIzqCol.setBounds(77, 55, 24, 20);
		panel_1.add(txtFldPosIzqCol);
		txtFldPosIzqCol.setColumns(10);

		txtFldPosIzqFil = new JTextField();
		txtFldPosIzqFil.setBounds(43, 55, 24, 20);
		panel_1.add(txtFldPosIzqFil);
		txtFldPosIzqFil.setColumns(10);

		JLabel lblIzq = new JLabel("izq:");
		lblIzq.setBounds(20, 55, 29, 21);
		panel_1.add(lblIzq);

		JLabel lblDer = new JLabel("der:");
		lblDer.setBounds(126, 54, 29, 21);
		panel_1.add(lblDer);

		txtFldPosDerCol = new JTextField();
		txtFldPosDerCol.setBounds(187, 55, 24, 20);
		panel_1.add(txtFldPosDerCol);
		txtFldPosDerCol.setColumns(10);

		txtFldPosDerFil = new JTextField();
		txtFldPosDerFil.setBounds(153, 55, 24, 20);
		panel_1.add(txtFldPosDerFil);
		txtFldPosDerFil.setColumns(10);

		JLabel lblIngresarPosicion = new JLabel("Ingresar posici\u00F3n ficha:");
		lblIngresarPosicion.setBounds(20, 23, 141, 21);
		panel_1.add(lblIngresarPosicion);
		
		JPanel panelRonda_1 = new JPanel();
		panelRonda_1.setBounds(284, 36, 218, 320);
		add(panelRonda_1);
	}

	public void initRonda(Ronda ronda) throws IOException {
		Image img = ImageIO.read(new File(".//src//img//Bosque.png"));
		panelRonda.setBounds(34, 36, 86 * 2, (86 * ronda.getCantidadDeJugadores()) + (20 * (ronda.getCantidadDeJugadores() - 1)));
		panelRonda.setLayout(new GridLayout(ronda.getCantidadDeJugadores(), 2, 0, 20));
		for (int i = 0; i < ronda.getCantidadDeJugadores(); i++) {
			for (int j = 0; j < 2; j++) {
				JButton temp = new JButton();
				temp.setPreferredSize(new Dimension(86, 86));
				temp.setIcon(new ImageIcon(img));
				temp.setEnabled(false);
				panelRonda.add(temp);
			}
		}
	}
}
