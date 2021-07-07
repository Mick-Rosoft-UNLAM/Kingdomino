package main.java.edu.unlam.taller.kingdomino.entornografico;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.java.edu.unlam.taller.kingdomino.utils.CargadorImg;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComponenteTablero extends JPanel {
	private static final long serialVersionUID = -574870386935501776L;
	
	private JLabel[][] tablero = new JLabel[9][9];
	
	private String direccionFicha = "ARRIBA";
	
	private CargadorImg cargadorImg = new CargadorImg(); 
	
	public ComponenteTablero() throws IOException {
		setLayout(new GridLayout(9, 9));
		setSize(new Dimension(540, 540));
		createButtonPanel();
	}

	public void createButtonPanel() throws IOException {
		for (int i = 0; i < 9; i++) {
			int indexI = i;
			for (int j = 0; j < 9; j++) {
				int indexJ = j;
				JLabel temp = new JLabel();
				temp.setPreferredSize(new Dimension(60, 60));
				temp.setOpaque(true);
				temp.setBackground(Color.BLACK);
				temp.setIcon(cargadorImg.getImg("VACIO"));
				temp.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if(direccionFicha.equals("ARRIBA")) {
							if(indexI > 0) {								
								temp.setIcon(cargadorImg.getImg("VACIO_SELECCIONADO"));
								tablero[indexI-1][indexJ].setIcon(cargadorImg.getImg("VACIO_SELECCIONADO"));
							}
						}
						
						if(direccionFicha.equals("DERECHA")) {
							if(indexJ < tablero.length - 1) {
								temp.setBackground(Color.CYAN);
								tablero[indexI][indexJ+1].setBackground(Color.CYAN);
							}
						}
						if(direccionFicha.equals("ABAJO")) {
							if(indexI < tablero.length - 1) {		
								temp.setBackground(Color.CYAN);
								tablero[indexI+1][indexJ].setBackground(Color.CYAN);
							}
						}
						if(direccionFicha.equals("IZQUIERDA")) {
							if(indexJ > 0) {		
								temp.setBackground(Color.CYAN);
								tablero[indexI][indexJ-1].setBackground(Color.CYAN);
							}
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						if(direccionFicha.equals("ARRIBA")) {
							if(indexI > 0) {
								temp.setIcon(cargadorImg.getImg("VACIO"));
								tablero[indexI-1][indexJ].setIcon(cargadorImg.getImg("VACIO"));
							}
						}
						if(direccionFicha.equals("DERECHA")) {
							if(indexJ < tablero.length - 1) {		
								temp.setBackground(Color.BLACK);
								tablero[indexI][indexJ+1].setBackground(Color.BLACK);
							}
						}
						if(direccionFicha.equals("ABAJO")) {
							if(indexI < tablero.length - 1) {		
								temp.setBackground(Color.BLACK);
								tablero[indexI+1][indexJ].setBackground(Color.BLACK);
							}
						}
						if(direccionFicha.equals("IZQUIERDA")) {
							if(indexJ > 0) {		
								temp.setBackground(Color.BLACK);
								tablero[indexI][indexJ-1].setBackground(Color.BLACK);
							}
						}
		            }
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(SwingUtilities.isRightMouseButton(e)) {
							switch(direccionFicha) {
							case "ARRIBA":
								tablero[indexI-1][indexJ].setBackground(Color.BLACK);
								tablero[indexI][indexJ+1].setBackground(Color.CYAN);
								direccionFicha = "DERECHA";
								break;
							case "DERECHA":
								tablero[indexI][indexJ+1].setBackground(Color.BLACK);
								tablero[indexI+1][indexJ].setBackground(Color.CYAN);
								direccionFicha = "ABAJO";
								break;
							case "ABAJO":
								tablero[indexI+1][indexJ].setBackground(Color.BLACK);
								tablero[indexI][indexJ-1].setBackground(Color.CYAN);
								direccionFicha = "IZQUIERDA";
								break;
							case "IZQUIERDA":
								tablero[indexI][indexJ-1].setBackground(Color.BLACK);
								tablero[indexI-1][indexJ].setBackground(Color.CYAN);
								direccionFicha = "ARRIBA";
								break;
							}
						}
					}
				});
				add(temp);
				tablero[i][j] = temp;
			}
		}
		tablero[4][4].setIcon(cargadorImg.getImg("CASTILLO"));
	}
}
