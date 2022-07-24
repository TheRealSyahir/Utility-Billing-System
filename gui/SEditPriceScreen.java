package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;
import data.meterPrice;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SEditPriceScreen extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MainFrame main;
	private meterPrice pri;
	private int index;
	
	public SEditPriceScreen(MainFrame main, int ind, meterPrice pri) {
		setLayout(null);
		this.main=main;
		this.index = ind;
		this.pri = pri;
		
		JLabel lblEditMeterPrice = new JLabel("Edit Meter Price($)");
		lblEditMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEditMeterPrice.setBounds(112, 47, 178, 20);
		add(lblEditMeterPrice);
		
		JLabel lblWater = new JLabel("Water:");
		lblWater.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWater.setBounds(63, 104, 69, 20);
		add(lblWater);
		
		JLabel lblGas = new JLabel("Gas:");
		lblGas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGas.setBounds(63, 146, 69, 20);
		add(lblGas);
		
		JLabel lblElectricity = new JLabel("Electricity:");
		lblElectricity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElectricity.setBounds(63, 190, 96, 20);
		add(lblElectricity);
		
		textField = new JTextField();
		textField.setBounds(195, 101, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 143, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(195, 187, 146, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo) {
				main.showSDPriceScreen();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(63, 238, 115, 29);
		add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				double wp = Double.valueOf(textField.getText());
				double gp = Double.valueOf(textField_1.getText());
				double ep = Double.valueOf(textField_2.getText());
				meterPrice newpri = new meterPrice(wp, gp ,ep);
				main.getController().editPrices(index, newpri);
				System.out.println("Meter Prices have been updated");
				main.showSDPriceScreen();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(226, 238, 115, 29);
		add(btnUpdate);
	}
}
