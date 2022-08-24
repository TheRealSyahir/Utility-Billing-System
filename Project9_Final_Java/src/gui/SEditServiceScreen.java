package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;
import data.serviceCharge;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SEditServiceScreen extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MainFrame main;
	private int index;
	private serviceCharge sch;
	
	public SEditServiceScreen(MainFrame main, int ind, serviceCharge sch) {
		setLayout(null);
		this.main=main;
		this.setSize(450,320);
		main.setSize(450,320);
		this.index = ind;
		this.sch = sch;
		
		JLabel lblEditServiceCharge = new JLabel("Edit Service Charge(%)");
		lblEditServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditServiceCharge.setBounds(109, 16, 208, 20);
		add(lblEditServiceCharge);
		
		JLabel lblWater = new JLabel("Water:");
		lblWater.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWater.setBounds(50, 65, 101, 20);
		add(lblWater);
		
		JLabel lblGas = new JLabel("Gas:");
		lblGas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGas.setBounds(50, 118, 69, 20);
		add(lblGas);
		
		JLabel lblElectricity = new JLabel("Electricity:");
		lblElectricity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElectricity.setBounds(50, 174, 101, 20);
		add(lblElectricity);
		
		textField = new JTextField();
		textField.setBounds(171, 62, 146, 26);
		add(textField);
		textField.setColumns(10);
		textField.setText(Double.valueOf(sch.getWCharge()).toString());
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 115, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(Double.valueOf(sch.getGCharge()).toString());
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 171, 146, 26);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(Double.valueOf(sch.getECharge()).toString());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showSDServiceScreen();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(45, 222, 115, 29);
		add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double wc = Double.valueOf(textField.getText());
				double gc = Double.valueOf(textField_1.getText());
				double ec = Double.valueOf(textField_2.getText());
				serviceCharge newsch = new serviceCharge(wc, gc, ec);
				main.getController().editCharges(index, newsch);
				System.out.println("Service Charges have been updated");
				main.showSDServiceScreen();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(202, 222, 115, 29);
		add(btnUpdate);
	} 
}
