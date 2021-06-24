package main.java.edu.unlam.taller.kingdomino.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Partida;

public class Servidor {

    private static final int puertoServidor = 4444;

    private List<HiloCliente> clientes;
    private Partida partida;

    public static void main(String[] args){
        Servidor servidor = new Servidor(puertoServidor);
        servidor.startServer();
    }

    public Servidor(int portNumber){
        this.partida = new Partida();
    }

    public List<HiloCliente> getClients(){
        return clientes;
    }

    private void startServer(){
        clientes = new ArrayList<HiloCliente>();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puertoServidor);
            aceptarClientes(serverSocket);
        } catch (IOException e){
            System.err.println("No se puede escuchar en el puerto: "+ puertoServidor);
            System.exit(1);
        }
    }

    private void aceptarClientes(ServerSocket socketServidor){

        System.out.println("Servedor inciado en puerto:" + socketServidor.getLocalSocketAddress());
        while(true){
            try{
                Socket socket = socketServidor.accept();
                System.out.println("Aceptado: " + socket.getRemoteSocketAddress());
                HiloCliente hiloCliente = new HiloCliente(this, socket);
                new Thread(hiloCliente).start();
                clientes.add(hiloCliente);
            } catch (IOException ex){
                System.out.println("Falló accept: "+ puertoServidor);
            }
        }
    }

	public boolean agregarJugador(Jugador jugador) {
		return partida.agregarJugador(jugador);
	}

	public String getJugadores() {
		return partida.getJugadores();
	}

	public void eliminarJugador(String message) {
		partida.eliminarJugador(message);
	}

	public Partida getPartida() {
		return partida;
	}

	public int getCantidadDeJugadores() {
		return partida.getCantDeJugadores();
	}

	public Object iniciarPartida() {
		return partida.iniciarPartida();
	}
}