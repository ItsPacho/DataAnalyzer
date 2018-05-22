package controller;

import java.io.*;
import java.net.*;

public class Connection {
	Socket requestSocket; // skapar en referens till requestSocket av typen Socket i klassen java.net
	String server = "120.232.233.149";
	int port = 50000;
	String message, sistaHalsning;
	PrintWriter output;
	BufferedReader input;
	BufferedReader konsolInlast;

	Connection() {

	}

	void run() {
		try {
			requestSocket = new Socket(server, port);
			System.out.println("Connected to 120.232.233.149 on port 50000 on " + requestSocket.getLocalPort());
			input = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(requestSocket.getOutputStream())), true);
			konsolInlast = new BufferedReader(new InputStreamReader(System.in));

			// Skapar en input socket lokalt p� klientmaskinen
			do {
				try {
					message = (String) input.readLine(); // l�ser in vad servern skickat
					System.out.println("server>" + message);

					System.out.println("ange vad du vill g�ra (skriv allts� 'add') ");
					message = konsolInlast.readLine();
					sendMessage(message); // skickar meddelandet add till metoden sendMessage

					message = (String) input.readLine(); // l�ser in vad servern skickat
					System.out.println("server>" + message);

					System.out.println("ange f�rsta heltalet:");
					message = "42";
					sendMessage(message); // message till metoden sendMessage

					message = (String) input.readLine(); // l�ser in vad servern skickat
					System.out.println("server>" + message);

					System.out.println("ange andra heltalet:");
					message = konsolInlast.readLine();
					sendMessage(message); // message till metoden sendMessage

					message = (String) input.readLine(); // l�ser in vad servern skickat
					System.out.println("server>" + message);

					message = input.readLine(); // l�ser svaret
					System.out.println(message);

					message = "bye";
					sendMessage(message); // skickar bye till metoden sendMessage

					sistaHalsning = input.readLine(); // l�ser svaret
					System.out.println(sistaHalsning);
				} catch (Exception e) {
					System.err.println("data received in unknown format");
				}
			} while (!message.equals("bye"));
		} catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			// St�nger av kommunikationen
			try {
				input.close(); // st�nger in socketen
				output.close(); // st�nger out socketen
				requestSocket.close(); // avslutar referensen
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	void sendMessage(String msg) {
		try {
			output.println(msg); // skriver p� utkanalen meddelandet
			System.out.flush();
			System.out.println("client>" + msg); // skriver ut vad klienten skickat
		} catch (Exception ioException) {
			ioException.printStackTrace();
		}
	}
}
