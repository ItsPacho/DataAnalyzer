package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DAFrame extends JFrame {
	public void Frame() {
		JFrame frame = new JFrame("Data Analyzer");
		frame.setContentPane(new DAView().DAPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(950, 570);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
