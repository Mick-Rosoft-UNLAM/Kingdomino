package main.java.edu.unlam.taller.kingdomino.entornografico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ComponenteTablero extends JPanel {
	private static final long serialVersionUID = -574870386935501776L;
	
	public ComponenteTablero() throws IOException {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(9, 9));
		setSize(new Dimension(540, 540));
		createButtonPanel();
	}

	public void createButtonPanel() throws IOException {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JButton temp = new JButton();
				temp.setPreferredSize(new Dimension(60, 60));
				temp.setBackground(new Color(Color.TRANSLUCENT));
				temp.setText(i + ", " + j);
				add(temp);
			}
		}
	}
}
