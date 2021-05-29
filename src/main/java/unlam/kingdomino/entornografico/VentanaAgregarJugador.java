package main.java.unlam.kingdomino.entornografico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaAgregarJugador extends JPanel{
	public VentanaAgregarJugador() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(197, 126, 49, 14);
		add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(181, 152, 86, 20);
		add(textField);
		textField.setColumns(10);
	}

	private static final long serialVersionUID = -2190704995900735227L;
	private JTextField textField;
}
