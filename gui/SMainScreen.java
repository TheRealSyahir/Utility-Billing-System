package gui;

import javax.swing.JPanel;

import controller.MainFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SMainScreen extends JPanel{
	
	private MainFrame main;
	
	public SMainScreen(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JLabel lblStaffAccount = new JLabel("STAFF ACCOUNT");
		lblStaffAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStaffAccount.setBounds(130, 53, 166, 20);
		add(lblStaffAccount);
		
		JButton btnSetMeterPrice = new JButton("Set Meter Price");
		btnSetMeterPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showSMeterScreen();
			}
		});
		btnSetMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetMeterPrice.setBounds(106, 118, 209, 29);
		add(btnSetMeterPrice);
		
		JButton btnSetServiceCharge = new JButton("Set Service Charge");
		btnSetServiceCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSServiceScreen();
			}
		});
		btnSetServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetServiceCharge.setBounds(106, 163, 209, 29);
		add(btnSetServiceCharge);
	} 
}
