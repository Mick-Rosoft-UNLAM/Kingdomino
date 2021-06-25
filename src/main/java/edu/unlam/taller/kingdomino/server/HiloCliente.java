package main.java.edu.unlam.taller.kingdomino.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import main.java.edu.unlam.taller.kingdomino.logica.Jugador;

public class HiloCliente implements Runnable {
	private Socket socket;
	private Servidor servidor;
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;

	public HiloCliente(Servidor server, Socket socket) {
		this.servidor = server;
		this.socket = socket;
	}

	private ObjectOutputStream getWriter() {
		return objectOutputStream;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

			// Iniciar comunicación
			while (!socket.isClosed()) {
				if (inputStream.available() > 0) {
					Object next = objectInputStream.readObject();
					if (next instanceof String) {
						String[] data = ((String) next).split("-");
						String dataType = data[0];
						String message = "";
						if (data.length > 1) {
							message = data[1];
						}
						Object mensajeOut = "";

						switch (dataType) {
						// Agregar Jugador
						case "AJ": {
							if (!servidor.agregarJugador(new Jugador(message))) {
								// Partida ya Iniciada
								mensajeOut = "PI";
							} else {
								mensajeOut = getJugadores(dataType);
							}
							break;
						}
						// Eliminar Jugador
						case "EJ": {
							servidor.eliminarJugador(message);
							mensajeOut = getJugadores(dataType);
							break;
						}
						// Iniciar Partida
						case "IP": {
							mensajeOut = iniciarPartida();
							break;
						}
						}

						if (mensajeOut != "PI") {
							for (HiloCliente thatClient : servidor.getClients()) {
								ObjectOutputStream thatClientOut = thatClient.getWriter();
								if (thatClientOut != null) {
									thatClientOut.writeObject(mensajeOut);
									thatClientOut.flush();
								}
							}
						} else {
							ObjectOutputStream thatClientOut = this.getWriter();
							thatClientOut.writeObject(mensajeOut);
							thatClientOut.flush();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String getJugadores(String dataType) {
		return dataType + "-" + servidor.getJugadores().replaceAll("[\\[+\\]+\\ ]", "");
	}

	private Object iniciarPartida() {
		return servidor.getPartida().iniciarPartida();
	}
}