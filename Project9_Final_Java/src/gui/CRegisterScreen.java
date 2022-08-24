package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CRegisterScreen extends JPanel{
	private JTextField textField;
	private MainFrame main;
	private JTextField textField_1;
	private JTextField textField_2;
	private double wb = 0.0;
	private double gb = 0.0;
	private double eb = 0.0;
	private double tb = 0.0;
	private int index;
	private Customer cust;
	
	public CRegisterScreen(MainFrame main) {
		setLayout(null);
		this.main=main;
		this.setSize(400, 300);
		main.setSize(420, 320);
		
		JLabel lblCustomerRegistration = new JLabel("Customer Details");
		lblCustomerRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerRegistration.setBounds(10, 31, 381, 20);
		add(lblCustomerRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(97, 78, 51, 20);
		add(lblName);
		
		JLabel lblHouseUnit = new JLabel("House Unit:");
		lblHouseUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHouseUnit.setBounds(55, 117, 93, 20);
		add(lblHouseUnit);
		
		textField = new JTextField();
		textField.setBounds(158, 78, 202, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm = textField.getText();
				String hn = textField_1.getText();
				String mm = textField_2.getText();
				
				main.getController().addCustomer(nm, hn,mm, wb, gb ,eb,tb);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				main.showCMeterScreen(index,cust);
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirm.setBounds(136, 226, 115, 29);
		add(btnConfirm);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 117, 115, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 154, 115, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setBounds(70, 157, 78, 20);
		add(lblMonth);
	}
}
