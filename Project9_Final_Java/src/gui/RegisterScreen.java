package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.MainFrame;


public class RegisterScreen extends JPanel{ 
	private MainFrame main;
	private JTextField textField;
	private JRadioButton rdbtnCust, rdbtnStaff;
	private JTextField textField_1;
	public RegisterScreen(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(350,250);
		main.setSize(360,280);
		
		JLabel lblRegisterUser = new JLabel("Register User");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegisterUser.setBounds(110, 32, 135, 20);
		add(lblRegisterUser);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(44, 68, 103, 20);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(44, 104, 91, 20);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(168, 65, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 104, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegisterUser = new JButton("Register User");
		btnRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegisterUser.setBounds(69, 190, 193, 29);
		add(btnRegisterUser);
		btnRegisterUser.addActionListener(new RegisterActionListener());
		
		ButtonGroup btnGroup = new ButtonGroup();
		this.rdbtnCust = new JRadioButton("Customer");
		rdbtnCust.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnCust.setBounds(69, 142, 115, 23);
		btnGroup.add(rdbtnCust);
		add(rdbtnCust);
		
		this.rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnStaff.setBounds(221, 142, 67, 23);
		add(rdbtnStaff);
		btnGroup.add(rdbtnStaff);

	} 
	private class RegisterActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String user = textField.getText();
			String pw = textField_1.getText();
			String g= " ";
			if(rdbtnCust.isSelected()){
			      g = rdbtnCust.getText();
			      main.showLoginScreen();
			 }
		
			 if(rdbtnStaff.isSelected()){
				 g = rdbtnStaff.getText();
				 main.showLoginScreen(); 
			 }
			 
			main.getController().addUser(user, pw, g);
		}
	}
}
