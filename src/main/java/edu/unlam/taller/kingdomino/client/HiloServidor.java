package main.java.edu.unlam.taller.kingdomino.client;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

import main.java.edu.unlam.taller.kingdomino.entornografico.App;

public class HiloServidor implements Runnable {
    private Socket socket;
    private final LinkedList<String> mensajesAEnviar;
    private boolean hayMensajes = false;
    private App app;

    public HiloServidor(Socket socket, App app){
    	this.app = app;
        this.socket = socket;
        mensajesAEnviar = new LinkedList<String>();
    }

    public void enviarMensaje(String message){
        synchronized (mensajesAEnviar){
            hayMensajes = true;
            mensajesAEnviar.push(message);
        }
    }

    @Override
    public void run(){
        try{
            InputStream serverInStream = socket.getInputStream();
            Scanner servidorIn = new Scanner(serverInStream);
            PrintWriter servidorOut = new PrintWriter(socket.getOutputStream(), false);
            while(!socket.isClosed()){
            	//Recepción de mensajes
                recibirMensajes(serverInStream, servidorIn);
                
                //Envio de mensajes
                enviarMensajes(servidorOut);
            }
            servidorIn.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

	private void enviarMensajes(PrintWriter servidorOut) {
		if(hayMensajes){
		    String mensajeAEnviar = "";
		    synchronized(mensajesAEnviar){
		        mensajeAEnviar = mensajesAEnviar.pop();
		        hayMensajes = !mensajesAEnviar.isEmpty();
		    }
		    servidorOut.println(mensajeAEnviar);
		    servidorOut.flush();
		}
	}

	private void recibirMensajes(InputStream serverInStream, Scanner servidorIn) throws IOException {
		if(serverInStream.available() > 0){
		    if(servidorIn.hasNextLine()){
		    	String[] data = servidorIn.nextLine().split("-");
		    	String dataTipo = data[0];
		    	String mensaje = "";
		    	if(data.length > 1) {
		    		mensaje = data[1];
		    	}
		    	switch(dataTipo) {
		        	case "JD": 
		        		app.setJugadores(mensaje);
		        		break;
		        	case "IP":
		        		app.iniciarPartida();
		        		break;
		        	case "NIP":
		        		app.mostrarMensajeJugadoresNotOk();
		    	}
		    }
		}
	}
}