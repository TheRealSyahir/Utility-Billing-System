package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SServiceScreen extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MainFrame main;
	
	public SServiceScreen(MainFrame main) {
		
		setLayout(null);
		this.main = main;
		
		JLabel lblWaterServiceCharge = new JLabel("Water Service Charge(%):");
		lblWaterServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWaterServiceCharge.setBounds(27, 89, 224, 20);
		add(lblWaterServiceCharge);
		
		JLabel lblGasServiceCharge = new JLabel("Gas Service Charge(%):");
		lblGasServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGasServiceCharge.setBounds(27, 135, 214, 20);
		add(lblGasServiceCharge);
		
		JLabel lblElectricityServiceCharge = new JLabel("Electricity Service Charge(%):");
		lblElectricityServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElectricityServiceCharge.setBounds(27, 171, 253, 20);
		add(lblElectricityServiceCharge);
		
		JLabel lblSetServiceCharge = new JLabel("Set Service Charge");
		lblSetServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSetServiceCharge.setBounds(114, 38, 197, 35);
		add(lblSetServiceCharge);
		
		textField = new JTextField();
		textField.setBounds(283, 89, 136, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 132, 136, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(283, 171, 136, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSet = new JButton("SET");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double wCharge = Double.valueOf(textField.getText());
				double gCharge = Double.valueOf(textField_1.getText());
				double eCharge = Double.valueOf(textField_2.getText());
				main.getController().addserviceCharge(wCharge, gCharge, eCharge);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				main.showSDServiceScreen();
			}
		});
		btnSet.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSet.setBounds(249, 213, 115, 29);
		add(btnSet);
		
		JButton btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSMainScreen();
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToMain.setBounds(73, 213, 144, 29);
		add(btnBackToMain);
	} 

}
