package main.java.edu.unlam.taller.kingdomino.client;

import java.io.IOException;
import java.net.Socket;

import main.java.edu.unlam.taller.kingdomino.entornografico.App;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

public class Cliente {

    private static final String host = "localhost";
    private static final int portNumber = 4444;

    private HiloServidor hiloServidor;
    private App app;
    private boolean socketConectado = false;
    
	Jugador jugador;

    public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Cliente(App app){
    	this.jugador = new Jugador(null);
    	this.app = app;
    }

    public void startClient(){
        try{
            Socket socket = new Socket(host, portNumber);
            Thread.sleep(1000);
            hiloServidor = new HiloServidor(socket, app);
            setSocketConectado(true);
            new Thread(hiloServidor).start();
        }catch(IOException ex){
            System.err.println("Error de conexión!");
            ex.printStackTrace();
        }catch(InterruptedException ex){
            System.out.println("Interrumpido");
        }
    }
    
    public void agregarJugador(String jugador) {
    	hiloServidor.enviarMensaje("AJ-" + jugador);
    }

	public void eliminarJugador(String jugador) {
		hiloServidor.enviarMensaje("EJ-" + jugador);
	}

	public void iniciarPartida() {
		hiloServidor.enviarMensaje("IP-");
	}

	public boolean isSocketConectado() {
		return socketConectado;
	}

	public void setSocketConectado(boolean socketConectado) {
		this.socketConectado = socketConectado;
	}

	public void elegirRey(String rey) {
		hiloServidor.enviarMensaje("ER-" + rey);
	}

	public void avanzarRonda(int nroFicha) {
		hiloServidor.enviarMensaje("AR-" + nroFicha);
	}
}