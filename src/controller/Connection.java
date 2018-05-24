package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import model.Message;
import view.DAView;

public class Connection {
	Socket requestSocket; // skapar en referens till requestSocket av typen Socket i klassen java.net
	String server = "127.0.0.1";
	int port = 50000;
	String message, sistaHalsning;
	PrintWriter output;
	BufferedReader input;
	BufferedReader konsolInlast;
	DAView theView = null;
	
	// SELECTED DATA

	public Connection(DAView theView) {
		this.theView = theView;
		
		theView.getDoRequest().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String humidityClicked = (String) theView.getHumidityCB().getSelectedItem();
				String velocityClicked = (String) theView.getVelocityCB().getSelectedItem();
				String temperatureClicked = (String) theView.getTemperatureCB().getSelectedItem();
				
				try {
					requestSocket = new Socket(server, port);
					System.out.println("Connected to 120.232.233.149 on port 50000 on " + requestSocket.getLocalPort());
					output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(requestSocket.getOutputStream())), true);
					konsolInlast = new BufferedReader(new InputStreamReader(System.in));
					
					output.println("1 1 1");
					Message newMessage;
					// GET OBJECT
					ObjectInputStream ois = new ObjectInputStream(requestSocket.getInputStream());
					try {
						newMessage = (Message) ois.readObject();
						System.out.println(newMessage.getHumidityArray().get(0));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Skapar en input socket lokalt på klientmaskinen
				} catch (UnknownHostException unknownHost) {
					System.err.println("You are trying to connect to an unknown host!");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
	}

	void run() {
		
	}
}
