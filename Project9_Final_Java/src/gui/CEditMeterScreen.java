package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MainFrame;
import data.meterReading;

public class CEditMeterScreen extends JPanel{
	private JTextField tfGas;
	private JTextField tfWater;
	private JTextField tfElec;
	
	private MainFrame main;

	public CEditMeterScreen(MainFrame main, int index, meterReading mR) {
		setLayout(null);
		this.main=main;
		this.setSize(450,300);
		main.setSize(450,300);
		
		JLabel lblTitleLabel = new JLabel("Edit Meter Reading");
		lblTitleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setBounds(0, 62, 438, 26);
		add(lblTitleLabel);
		
		JLabel lblGas = new JLabel("Gas");
		lblGas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGas.setHorizontalAlignment(SwingConstants.CENTER);
		lblGas.setBounds(116, 104, 61, 16);
		add(lblGas);
		
		tfGas = new JTextField();
		tfGas.setBounds(233, 99, 93, 26);
		add(tfGas);
		tfGas.setColumns(10);
		tfGas.setText(Double.valueOf(mR.getGas()).toString());
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblWater.setBounds(116, 155, 61, 16);
		add(lblWater);
		
		tfWater = new JTextField();
		tfWater.setBounds(233, 150, 93, 26);
		add(tfWater);
		tfWater.setColumns(10); 
		tfWater.setText(Double.valueOf(mR.getWat()).toString());
		
		JLabel lblElec = new JLabel("Electricity");
		lblElec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElec.setHorizontalAlignment(SwingConstants.CENTER);
		lblElec.setBounds(116, 197, 82, 16);
		add(lblElec);
		
		tfElec = new JTextField();
		tfElec.setBounds(233, 192, 93, 26);
		add(tfElec);
		tfElec.setColumns(10);
		tfElec.setText(Double.valueOf(mR.getEle()).toString());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double newWat = Double.valueOf(tfWater.getText());
				double newGas = Double.valueOf(tfGas.getText());
				double newEle = Double.valueOf(tfElec.getText());
				meterReading newMR = new meterReading(newWat, newGas, newEle);
				main.getController().editMeterReading(index, newMR);
				JOptionPane.showMessageDialog(null,"Your meter reading has been updated", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				main.showCDMeterScreen();
			}
		});
		btnUpdate.setBounds(158, 237, 117, 29);
		add(btnUpdate);
	} 
}
