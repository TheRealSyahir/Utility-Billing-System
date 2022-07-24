package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SMeterScreen extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MainFrame main;
	
	public SMeterScreen(MainFrame main) {
		
		setLayout(null);
		this.main=main;
		
		JLabel lblWaterMeterPrice = new JLabel("Water Meter Price($):");
		lblWaterMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWaterMeterPrice.setBounds(26, 110, 187, 20);
		add(lblWaterMeterPrice);
		
		JLabel lblGasMeterPrice = new JLabel("Gas Meter Price($):");
		lblGasMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGasMeterPrice.setBounds(26, 146, 187, 20);
		add(lblGasMeterPrice);
		
		JLabel lblElectricityMeterPrice = new JLabel("Electricity Meter Price($):");
		lblElectricityMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElectricityMeterPrice.setBounds(26, 179, 212, 20);
		add(lblElectricityMeterPrice);
		
		JLabel lblSetMeterPrice = new JLabel("Set Meter Price");
		lblSetMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSetMeterPrice.setBounds(133, 40, 162, 32);
		add(lblSetMeterPrice);
		
		textField = new JTextField();
		textField.setBounds(253, 107, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(253, 143, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(253, 176, 146, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSet = new JButton("SET");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double wPrice = Double.valueOf(textField.getText());
				double gPrice = Double.valueOf(textField_1.getText());
				double ePrice = Double.valueOf(textField_2.getText());
				main.getController().addmeterPrice(wPrice, gPrice, ePrice);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				main.showSDPriceScreen();
			}
		});
		btnSet.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSet.setBounds(228, 219, 115, 29);
		add(btnSet);
		
		JButton btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSMainScreen();
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToMain.setBounds(56, 220, 146, 29);
		add(btnBackToMain);
	} 
}
