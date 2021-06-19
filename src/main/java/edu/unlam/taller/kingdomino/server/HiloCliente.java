package main.java.edu.unlam.taller.kingdomino.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

public class HiloCliente implements Runnable {
    private Socket socket;
    private PrintWriter clienteOut;
    private Servidor servidor;

    public HiloCliente(Servidor server, Socket socket){
        this.servidor = server;
        this.socket = socket;
    }

    private PrintWriter getWriter(){
        return clienteOut;
    }

    @Override
    public void run() {
        try{
            this.clienteOut = new PrintWriter(socket.getOutputStream(), false);
            Scanner in = new Scanner(socket.getInputStream());

            //Iniciar comunicación
            while(!socket.isClosed()){
                if(in.hasNextLine()){
                	String[] data = in.nextLine().split("-");
                	String dataType = data[0];
                	String message = "";
                	if(data.length > 1) {
                		message = data[1];
                	}
                	String mensajeOut = "";
                	
                	switch(dataType) {
                		case "AJ": {
                			servidor.agregarJugador(new Jugador(message));
                			mensajeOut = getCantidadDeJugadores();
                		}
                		break;
                		case "EJ": {
                			servidor.eliminarJugador(message);
                			mensajeOut = getCantidadDeJugadores();
                		}
                		break;
                		case "IP": {
                			mensajeOut = iniciarPartida();
                		}
                		break;
                	}
                	
        			for(HiloCliente thatClient : servidor.getClients()){
        				PrintWriter thatClientOut = thatClient.getWriter();
        				if(thatClientOut != null){
        					thatClientOut.write(mensajeOut + "\n");
        					thatClientOut.flush();
        				}
        			}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private String getCantidadDeJugadores() {
		String mensajeOut;
		mensajeOut = "JD-" + servidor.getJugadores().replaceAll("[\\[+\\]+\\ ]", "");
		return mensajeOut;
	}

	private String iniciarPartida() {
		String mensajeOut;
		if(servidor.getPartida().cantJugadoresOk()) {
			mensajeOut = "IP";
		} else {
			mensajeOut = "NIP";
		}
		return mensajeOut;
	}
}