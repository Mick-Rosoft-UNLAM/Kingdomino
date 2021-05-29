package main.java.unlam.kingdomino.entornografico;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JPanel {
	private static final long serialVersionUID = 7406620519646534966L;

	public VentanaPrincipal(CardLayout cardLayout, JPanel panelContainer) throws IOException {
		setLayout(null);
		add(setImagen());
		add(setBotonInicio(cardLayout, panelContainer));
	}

	private JButton setBotonInicio(CardLayout cardLayout, JPanel panelContainer) {
		JButton botonInicio = new JButton("Jugar");
		botonInicio.setLocation(348, 141);
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panelContainer, "2");
			}
		});
		
		botonInicio.setSize(70, 20);
		return botonInicio;
	}

	private JLabel setImagen() throws IOException {
		BufferedImage imgKingDomino = ImageIO.read(new File("C://Users//Usuario//Desktop//pic3132685.png"));
		JLabel lblImgKingDomino = new JLabel(new ImageIcon(imgKingDomino));
		lblImgKingDomino.setHorizontalAlignment(SwingConstants.LEFT);
		lblImgKingDomino.setBounds(0, 0, 300, 303);
		return lblImgKingDomino;
	}
}
