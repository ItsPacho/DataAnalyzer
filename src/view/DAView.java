package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DAView {

	private JTextField dataTF;
	private JScrollPane dataTFS;
	private JComboBox<String> humidityCB = new JComboBox<String>();
	private JComboBox<String> velocityCB = new JComboBox<String>();
	private JComboBox<String> temperatureCB = new JComboBox<String>();
	private JComboBox<String> dataAnalysisCB = new JComboBox<String>();
	private JButton doRequest = new JButton();
	private JButton doAnalysis = new JButton();

	public JComboBox<String> getHumidityCB() {
		return humidityCB;
	}

	public JComboBox<String> getVelocityCB() {
		return velocityCB;
	}

	public JComboBox<String> getTemperatureCB() {
		return temperatureCB;
	}
	
	public JButton getDoRequest() {
		return doRequest;
	}

	public JPanel DAPanel;

	public DAView() {

		// Styling
		GridBagConstraints gbc;

		// Main panel
		DAPanel = new JPanel();
		DAPanel.setLayout(new GridLayout(1, 2));

		// Options panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridBagLayout());

		// Data panel
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridBagLayout());

		// Panel splitting
		DAPanel.add(optionsPanel);
		DAPanel.add(dataPanel);

		//// -> optionsPanel <-////

		/// -> ROW 1 <-///

		// Data input label
		JLabel humidityCBLabel = new JLabel();
		humidityCBLabel.setText("Data input:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		optionsPanel.add(humidityCBLabel, gbc);

		// humidityComboBox
		DefaultComboBoxModel<String> DVHumidity = new DefaultComboBoxModel<String>(); // DV -> defaultValueu
		DVHumidity.addElement("Humidity");
		DVHumidity.addElement("None");
		humidityCB.setModel(DVHumidity);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		humidityCB.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(humidityCB, gbc);

		// comboBox spacer
		JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		optionsPanel.add(spacer1, gbc);

		// temperatureComboBox
		DefaultComboBoxModel<String> DVTemperature = new DefaultComboBoxModel<String>(); // DV -> defaultValue
		DVTemperature.addElement("Temperature");
		DVTemperature.addElement("None");
		temperatureCB.setModel(DVTemperature);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		temperatureCB.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(temperatureCB, gbc);

		// comboBox spacer
		JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		optionsPanel.add(spacer2, gbc);

		// velocityComboBox
		DefaultComboBoxModel<String> DVVelocity = new DefaultComboBoxModel<String>(); // DV -> defaultValue
		DVVelocity.addElement("Velocity");
		DVVelocity.addElement("None");
		velocityCB.setModel(DVVelocity);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		velocityCB.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(velocityCB, gbc);

		// comboBox spacer
		JPanel spacer3 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		optionsPanel.add(spacer3, gbc);

		// doRequestButton
		doRequest.setText("Do Request");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		doRequest.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(doRequest, gbc);

		/// -> ROW 2 <-///

		// panel spacer
		JPanel panelSpacer = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		optionsPanel.add(panelSpacer, gbc);

		// dataAnalysisCB(ComboBox) label
		JLabel dataAnalysisCBLabel = new JLabel();
		dataAnalysisCBLabel.setText("Data Analysis:");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		optionsPanel.add(dataAnalysisCBLabel, gbc);

		// dataAnalysisComboBox
		DefaultComboBoxModel<String> DVAnalysis = new DefaultComboBoxModel<String>(); // DV -> defaultValue
		DVAnalysis.addElement("Average");
		DVAnalysis.addElement("Variance");
		DVAnalysis.addElement("Standard deviation");
		dataAnalysisCB.setModel(DVAnalysis);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		dataAnalysisCB.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(dataAnalysisCB, gbc);

		// spacer
		JPanel spacer4 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		optionsPanel.add(spacer4, gbc);

		// doAnalysisButton
		doAnalysis.setText("Do Analysis");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		doAnalysis.setPreferredSize(new Dimension(140, 24));
		optionsPanel.add(doAnalysis, gbc);

		//// -> OP END <-////

		//// -> dataPanel <-////

		// dataTF(TextField) label
		JLabel TFLabel = new JLabel();
		TFLabel.setText("Data output:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		dataPanel.add(TFLabel, gbc);

		// dataTF(TextField) with JScrollPane
		dataTFS = new JScrollPane();
		dataTFS.setAutoscrolls(true);
		dataTFS.setPreferredSize(new Dimension(450, 500));
		dataTFS.setVerticalScrollBarPolicy(22);
		dataTFS.setWheelScrollingEnabled(true);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		dataPanel.add(dataTFS, gbc);
		dataTF = new JTextField();
		dataTF.setEditable(false);
		dataTF.setOpaque(false);
		dataTFS.setViewportView(dataTF);

		//// -> DP END <-////
	}
}