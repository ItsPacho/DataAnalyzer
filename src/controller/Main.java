package controller;

import javax.swing.SwingUtilities;

import view.DAFrame;
import view.DAView;

public class Main {

	public static void main(String[] args) {
		
		// CREATING A VIEW OBJECT
		DAView theView = new DAView();

		// Sätter igång programmet
		SwingUtilities.invokeLater(() -> new DAFrame().Frame(theView));

		// Skapar en connection med servern
		Connection client = new Connection(theView);
	}
}