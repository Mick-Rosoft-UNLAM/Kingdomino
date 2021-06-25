package main.java.edu.unlam.taller.kingdomino.entornografico;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.java.edu.unlam.taller.kingdomino.client.Cliente;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class App {
	private CardLayout cardLayout = new CardLayout(0, 0);
	
	//Frame
	private JFrame frame = new JFrame();
	JPanel panelContainer = new JPanel();
	
	//Componentes
	VentanaCrearPartida ventanaCrearPartida;
	VentanaPrincipal ventanaPrincial;
	VentanaUnirse ventanaUnirse;
	VentanaAgregarJugador ventanaAgregarJugador;
	VentanaPartida ventanaPartida;
	
	//Cliente
	Cliente cliente = new Cliente(this);
	
	//Jugador
	Jugador jugador = new Jugador(null);
	
	public App() throws IOException {
		initFrame();	
	}
	
	public static void main(String[] args) throws IOException {
		new App();
	}

	private void initComponentes() throws IOException {
		ventanaPrincial = new VentanaPrincipal(cardLayout, panelContainer);
		panelContainer.add(ventanaPrincial, "1");
		ventanaAgregarJugador = new VentanaAgregarJugador(panelContainer, jugador, cliente);
		panelContainer.add(ventanaAgregarJugador, "2");
		ventanaPartida = new VentanaPartida();
		panelContainer.add(ventanaPartida, "3");
		ventanaCrearPartida = new VentanaCrearPartida(panelContainer, cliente);
		panelContainer.add(ventanaCrearPartida, "4");
		ventanaUnirse = new VentanaUnirse(panelContainer, jugador);
		panelContainer.add(ventanaUnirse, "5");
	}

	private void initFrame() throws IOException {
		panelContainer.setLayout(cardLayout);
		frame.setTitle("Kindomino");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(500, 303));
		frame.setSize(500, 303);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		initComponentes();
		frame.add(panelContainer);
		frame.pack();
		frame.setVisible(true);
		
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		    	if(cliente.isSocketConectado()) {
		    		int confirm = JOptionPane.showOptionDialog(
		    				null, "Seguro que desea desconectarse?", 
		    				"Exit Confirmation", JOptionPane.YES_NO_OPTION, 
		    				JOptionPane.QUESTION_MESSAGE, null, null, null);
		    		if (confirm == 0) {
		    			cliente.eliminarJugador(jugador.getName());		        		
		    			System.exit(0);
		    		}
		    	} else {		    		
		    		System.exit(0);
		    	}
		    }
		};
		frame.addWindowListener(exitListener);
	}
	

	public void setJugadores(String jugadores) {

		ventanaCrearPartida.setJugadores(jugadores);
	}

	public void iniciarPartida(Ronda ronda) throws IOException {
		cambiarDimensionFrame(new Dimension(1230, 600));
		cardLayout.show(panelContainer, "3");
		ventanaPartida.initRonda(ronda);
	}
	
	private void cambiarDimensionFrame(Dimension dimension) {
		frame.getContentPane().setPreferredSize(dimension);
		frame.setSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

	public void mostrarMensajeJugadoresNotOk() {
		JOptionPane.showMessageDialog(null, "No se puede iniciar la partida. La cantidad de jugadores es incorrecta.");
	}

	public void mostrarMensajePartidaYaIniciada() {
		JOptionPane.showMessageDialog(null, "No se puede ingresar a una partida ya iniciada.");
	}

	public void mostrarVentanaCrearPartida() {
		cardLayout.show(panelContainer, "4");
	}

	public void bloquearReyElegido(String rey) {
		ventanaCrearPartida.getBtnRey(rey).setEnabled(false);
	}

	public void mostrarMensajeReyYaElegido() {
		JOptionPane.showMessageDialog(null, "Ya elegiste un Rey.");
	}
}
