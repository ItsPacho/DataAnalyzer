package controller;

import javax.swing.SwingUtilities;

import view.DAFrame;

public class Main {

	public static void main(String[] args) {

		// Sätter igång programmet
		SwingUtilities.invokeLater(() -> new DAFrame().Frame());

		// Skapar en connection med servern
		Connection client = new Connection();
		client.run();
	}
}