package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import main.java.edu.unlam.taller.kingdomino.client.Cliente;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeTerminarRonda.TerminarRonda;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;
import main.java.edu.unlam.taller.kingdomino.utils.CargadorImg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComponenteRonda extends JPanel {

	private static final long serialVersionUID = 823404469605528280L;
	private JTextField txtFldPosIzqFil;
	private JTextField txtFldPosIzqCol;
	private JTextField txtFldPosDerFil;
	private JTextField txtFldPosDerCol;
	private JPanel panel_1;
	private JPanel panelFichasActuales;
	private CargadorImg cargadorImg;
	private Timer timer;
	private JLabel[][] fichasActuales;
	private JLabel[][] fichasJugadas = new JLabel[4][3];

	private Cliente cliente;
	
	private Ronda ronda;
	
	private JPanel panelFichasJugadas;

	public ComponenteRonda(Cliente cliente) throws IOException {
		this.cliente = cliente;
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(540, 540));
		setLayout(null);
		cargadorImg = new CargadorImg();

		panelFichasActuales = new JPanel();
		
		panelFichasJugadas = new JPanel();
		add(panelFichasJugadas);
		
		panelFichasActuales.setBounds(275, 34, 227, 320);
		add(panelFichasActuales);

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

		
	}
	
	public void initRonda(Ronda r) {
		fichasActuales = new JLabel[r.getCantidadDeJugadores()][3];
		fichasJugadas = new JLabel[r.getCantidadDeJugadores()][3];
		setPanelFichas(r, panelFichasActuales, true);
	}
	
	public void setPanelFichas(Ronda r, JPanel panelFichas, boolean actuales) {
		this.ronda = r;
		panelFichas.removeAll();
		panelFichas.setBackground(Color.LIGHT_GRAY);
		panelFichas.setBounds(290, 34, 86 * 3,
				(86 * r.getCantidadDeJugadores()) + (20 * (r.getCantidadDeJugadores() - 1)));
		panelFichas.setLayout(new GridLayout(r.getCantidadDeJugadores(), 3, 0, 20));

		String[] imgFichas = r.getFichas().replaceAll("[\\[+\\]+\\ ]", "").split(",");
		
		for (int i = 0; i < r.getCantidadDeJugadores(); i++) {
			String[] imgFichasJugador = imgFichas[i].split("_");
			JLabel rey = new JLabel();
			rey.setPreferredSize(new Dimension(86, 86));
			int ordenFicha = i;
			for (int j = 0; j < 2; j++) {
				JLabel temp = new JLabel();
				temp.setPreferredSize(new Dimension(86, 86));
				System.out.println(imgFichasJugador[j]);
				ImageIcon imageIcon = cargadorImg.getImg(imgFichasJugador[j]);
				
				System.out.println(imageIcon.getImageLoadStatus());
				temp.setIcon(imageIcon);
				temp.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (ronda.getJugadorTurno().getName().equals(cliente.getJugador().getName())) {
							cliente.avanzarRonda(ordenFicha);
						}
					}
				});
				fichasActuales[i][j] = temp;
				temp.repaint();
				panelFichas.add(temp);
			}
			panelFichas.add(rey);
			if(actuales) {
				fichasActuales[i][2] = rey;				
			} else {
				fichasJugadas[i][2] = rey;
			}
		}
	}

	public void avanzarRonda(Ronda r) {
		this.ronda = r;
		fichasActuales[r.getNroFichaTurnoAnterior()][2].setIcon(cargadorImg.getImg(r.getJugadorTurnoAnterior().getRey()));
	}
	
	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	public void terminarRonda(TerminarRonda terminarRonda) {
		fichasActuales[terminarRonda.getRondaAnterior().getNroFichaTurnoAnterior()][2].setIcon(cargadorImg.getImg(terminarRonda.getRondaAnterior().getJugadorTurnoAnterior().getRey()));
		setPanelFichas(terminarRonda.getRondaAnterior(), this.panelFichasJugadas, false);
		setFichasJugadas(this.panelFichasJugadas);
		setPanelFichas(terminarRonda.getRonda(), this.panelFichasActuales, true);
		moverPanel(this.panelFichasJugadas);
	}
	
	private void setFichasJugadas(JPanel panelFichasJugadas) {
		for(int i = 0; i < fichasActuales.length; i++) {
			fichasJugadas[i][2].setIcon(fichasActuales[i][2].getIcon());
		}
	}

	public void moverPanel(JPanel panel) {
		timer = new Timer(1, event -> {
			if (panel.getX() > 25) {
				panel.setBounds(panel.getX() - 5, 34, panel.getWidth(), panel.getHeight());
			} else {
				timer.stop();
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}
}
