package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Customer;


public class LoginScreen extends JPanel{ 
	private MainFrame main;
	private JTextField textField;
	private JTextField textField_1;
	private int index;
	private Customer cust;
	public LoginScreen(MainFrame main) {
		
		setLayout(null);
		this.main = main;
		this.setSize(344, 268);
		main.setSize(350,280);
		
		JLabel lblLoginPage = new JLabel("Login Screen");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginPage.setBounds(106, 11, 122, 20);
		add(lblLoginPage);
		
		JLabel lblEnterUserName = new JLabel("User Name:");
		lblEnterUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterUserName.setBounds(33, 75, 98, 20);
		add(lblEnterUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(33, 132, 93, 20);
		add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(192, 199, 115, 29);
		add(btnLogin);
		btnLogin.addActionListener(new LoginActionListener());
		
		textField = new JTextField();
		textField.setBounds(161, 72, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 129, 146, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showRegisterScreen();
			}
		});
		btnRegister.setBounds(33, 199, 115, 29);
		add(btnRegister);
	} 
	private class LoginActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = textField.getText();
			String pw = textField_1.getText();
			
			boolean validity= main.getController().checkUser(user, pw);	
			String type = main.getController().getTypeName();
			if(validity == true){
				if(type.equals("Customer")){
					System.out.println("THE TYPE IS:"+type);
				    main.showCRegisterScreen();
				    }
				else{
					main.showSMainScreen();
					System.out.println("THE TYPE IS:"+type);
					}
			}
			
		}
	}
}
