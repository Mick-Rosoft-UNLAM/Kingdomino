package main.java.edu.unlam.taller.kingdomino.client;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

import main.java.edu.unlam.taller.kingdomino.entornografico.App;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class HiloServidor implements Runnable {
	private Socket socket;
	private final LinkedList<String> mensajesAEnviar;
	private boolean hayMensajes = false;
	private App app;

	public HiloServidor(Socket socket, App app) {
		this.app = app;
		this.socket = socket;
		mensajesAEnviar = new LinkedList<String>();
	}

	public void enviarMensaje(String message) {
		synchronized (mensajesAEnviar) {
			hayMensajes = true;
			mensajesAEnviar.push(message);
		}
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			ObjectOutputStream objectOutPutStream = new ObjectOutputStream(socket.getOutputStream());
			
			
			while (!socket.isClosed()) {
				// Recepción de mensajes
				recibirMensajes(objectInputStream, inputStream);

				// Envio de mensajes
				enviarMensajes(objectOutPutStream);
			}
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private void enviarMensajes(ObjectOutputStream objectOutPutStream) throws IOException {
		if (hayMensajes) {
			String mensajeAEnviar = "";
			synchronized (mensajesAEnviar) {
				mensajeAEnviar = mensajesAEnviar.pop();
				hayMensajes = !mensajesAEnviar.isEmpty();
			}
			objectOutPutStream.writeObject(mensajeAEnviar);
			objectOutPutStream.flush();
		}
	}

	private void recibirMensajes(ObjectInputStream objectInputStream, InputStream inputStream) throws IOException, ClassNotFoundException {
		if(inputStream.available() > 0) {			
			Object next = objectInputStream.readObject();
			if (next instanceof String) {
				manejoMensajeString(next);
			} else if (next instanceof Ronda) {
				manejoMensajeRonda(next);
			}
		}
	}

	private void manejoMensajeRonda(Object next) throws IOException {
		System.out.println(((Ronda) next).getFichas());
		app.iniciarPartida((Ronda) next);
	}

	private void manejoMensajeString(Object next) {
		String[] data = ((String) next).split("-");
		String dataTipo = data[0];
		String mensaje = "";
		if (data.length > 1) {
			mensaje = data[1];
		}
		switch (dataTipo) {
		case "AJ":
			app.mostrarVentanaCrearPartida();
			app.setJugadores(mensaje);
			break;
		case "EJ":
			app.setJugadores(mensaje);
			break;
		case "NIP":
			app.mostrarMensajeJugadoresNotOk();
			break;
		case "PI":
			app.mostrarMensajePartidaYaIniciada();
			break;
		}
	}
}