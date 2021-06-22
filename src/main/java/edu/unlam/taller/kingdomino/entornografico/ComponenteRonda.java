package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class ComponenteRonda extends JPanel {

	private static final long serialVersionUID = 823404469605528280L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public ComponenteRonda() {
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(540, 540));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 36, 468, 320);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar posici\u00F3n ficha:");
		lblNewLabel.setBounds(22, 242, 141, 21);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(45, 274, 24, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 274, 24, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 274, 24, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 274, 24, 20);
		panel.add(textField_3);
		
		JLabel lblIzq = new JLabel("izq:");
		lblIzq.setBounds(22, 274, 29, 21);
		panel.add(lblIzq);
		
		JLabel lblDer = new JLabel("der:");
		lblDer.setBounds(128, 273, 29, 21);
		panel.add(lblDer);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 231, 448, 8);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(34, 385, 468, 98);
		add(panel_1);
	}
	
	public void initRonda() {
		
	}
}
