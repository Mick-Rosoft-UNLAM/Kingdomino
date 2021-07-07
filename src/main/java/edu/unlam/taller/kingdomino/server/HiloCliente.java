package main.java.edu.unlam.taller.kingdomino.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import main.java.edu.unlam.taller.kingdomino.dto.Mensaje;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeAvanzarRonda;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeIniciarPartida;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeNoIniciarPartida;
import main.java.edu.unlam.taller.kingdomino.dto.MensajeTerminarRonda;
import main.java.edu.unlam.taller.kingdomino.logica.Jugador;
import main.java.edu.unlam.taller.kingdomino.logica.Ronda;

public class HiloCliente implements Runnable {
	private Socket socket;
	private Servidor servidor;
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;
	
	Jugador jugador = new Jugador(null);

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
			Object mensajeOut = null;
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

						switch (dataType) {
						// Agregar Jugador
						case "AJ": {
							jugador.setName(message);
							if (!servidor.agregarJugador(jugador)) {
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
						//Elegir Rey
						case "ER": {
							mensajeOut = elegirRey(message);
							break;
						}
						case "AR": {
							mensajeOut = avanzarRonda(message);
							break;
						}
						}

					}
					if (mensajeOut != "PI" && mensajeOut != "RYE") {
						for (HiloCliente thatClient : servidor.getClients()) {
							ObjectOutputStream thatClientOut = thatClient.getWriter();
							thatClientOut.reset();
							thatClientOut.writeObject(mensajeOut);
							thatClientOut.flush();
						}
					} else {
						ObjectOutputStream thatClientOut = this.getWriter();
						thatClientOut.writeObject(mensajeOut);
						thatClientOut.flush();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Mensaje avanzarRonda(String message) throws IOException {
		if(servidor.getPartida().ultimoTurnoRonda()) {
			return new MensajeTerminarRonda(servidor.getPartida().avanzarRonda(Integer.valueOf(message)), servidor.getPartida().nuevaRonda());
		} else {			
			return new MensajeAvanzarRonda(servidor.getPartida().avanzarRonda(Integer.valueOf(message)));		
		}
	}

	private String elegirRey(String message) {
		if(jugador.getRey() == null) {			
			jugador.setRey(message);
			//Rey Elegido
			return "RE-" + message;
		} else {
			//Rey Ya Elegido
			return "RYE";
		}
	}

	private String getJugadores(String dataType) {
		return dataType + "-" + servidor.getJugadores().replaceAll("[\\[+\\]+\\ ]", "");
	}

	private Mensaje iniciarPartida() {
		Ronda ronda = servidor.getPartida().iniciarPartida();
		return ronda != null ? new MensajeIniciarPartida(ronda) : new MensajeNoIniciarPartida("NIP");
	}
}