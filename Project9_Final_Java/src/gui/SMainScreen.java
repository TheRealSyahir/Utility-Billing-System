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
	private int index;
	
	public SMainScreen(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(450,320);
		main.setSize(450,320);
		
		JLabel lblStaffAccount = new JLabel("STAFF ACCOUNT");
		lblStaffAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStaffAccount.setBounds(137, 51, 166, 20);
		add(lblStaffAccount);
		
		JButton btnSetMeterPrice = new JButton("Set Meter Price");
		btnSetMeterPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showSPriceScreen();
			}
		});
		btnSetMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetMeterPrice.setBounds(25, 116, 181, 29);
		add(btnSetMeterPrice);
		
		JButton btnSetServiceCharge = new JButton("Set Service Charge");
		btnSetServiceCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSServiceScreen();
			}
		});
		btnSetServiceCharge.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSetServiceCharge.setBounds(231, 116, 190, 29);
		add(btnSetServiceCharge);
		
		JButton btnViewCustomerBills = new JButton("View Customer Bills");
		btnViewCustomerBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSBillScreen();
			}
		});
		btnViewCustomerBills.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewCustomerBills.setBounds(115, 173, 209, 29);
		add(btnViewCustomerBills);
		
		JButton btnBackToRegister = new JButton("Back to Register");
		btnBackToRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showRegisterScreen();
			}
		});
		btnBackToRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToRegister.setBounds(25, 235, 181, 29);
		add(btnBackToRegister);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginScreen();
			}
		});
		btnBackToLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToLogin.setBounds(242, 235, 166, 29);
		add(btnBackToLogin);
	} 
}
