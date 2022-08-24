package gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import controller.MainFrame;
import data.Customer;
import java.awt.Color;

public class CMeterScreen extends JPanel{
	private JTextField tfWaterReading;
	private JTextField tfGasReading;
	private JTextField tfEleReading;
	private Customer[] cust;
	private MainFrame main;
	private Customer cus;
	
	private String a="";
	private String b="";
	private String c ="";
	
	private int index;
	
	public CMeterScreen(MainFrame main,int ind, Customer cus) {
		this.main = main;
		this.index = ind;
		this.cus = cus;
		this.setSize(500,450);
		main.setSize(500,450);
		setLayout(null);
		
		JLabel lblPanelTitleLabel = new JLabel("Submit Meter Reading");
		lblPanelTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPanelTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitleLabel.setBounds(175, 11, 246, 29);
		add(lblPanelTitleLabel);
		
		JLabel lblWaterReadingLabel = new JLabel("Water Reading(cu M):");
		lblWaterReadingLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWaterReadingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblWaterReadingLabel.setBounds(109, 143, 189, 21);
		add(lblWaterReadingLabel);
		
		JLabel lblGasReadingLabel = new JLabel("Gas Reading(kWh):");
		lblGasReadingLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGasReadingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblGasReadingLabel.setBounds(135, 203, 163, 21);
		add(lblGasReadingLabel);
		
		JLabel lblElecReadingLabel = new JLabel("Electricity Reading(kWh):");
		lblElecReadingLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblElecReadingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblElecReadingLabel.setBounds(83, 259, 215, 21);
		add(lblElecReadingLabel);
		
		tfWaterReading = new JTextField();
		tfWaterReading.setForeground(Color.BLACK);
		tfWaterReading.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfWaterReading.setText("enter reading here");
		tfWaterReading.setBounds(296, 137, 159, 26);
		add(tfWaterReading);
		tfWaterReading.setColumns(10);
		tfWaterReading.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfWaterReading.setText("");
			}
		});
		
		tfGasReading = new JTextField();
		tfGasReading.setText("enter reading here");
		tfGasReading.setBounds(300, 198, 159, 26);
		add(tfGasReading);
		tfGasReading.setColumns(10);
		tfGasReading.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfGasReading.setText("");
			}
		});
		
		tfEleReading = new JTextField();
		tfEleReading.setText("enter reading here");
		tfEleReading.setBounds(296, 254, 159, 26);
		add(tfEleReading);
		tfEleReading.setColumns(10);
		tfEleReading.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfEleReading.setText("");
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double WatReading = Double.valueOf(tfWaterReading.getText());
				double GasReading = Double.valueOf(tfGasReading.getText());
				double EleReading = Double.valueOf(tfEleReading.getText());
				main.getController().addmeterReading(WatReading, GasReading,EleReading);
				
				main.getController().calcBill(cust[index]);
				JOptionPane.showMessageDialog(null,"Your meter reading has been submitted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSubmit.setBounds(47, 350, 139, 29);
		add(btnSubmit);
		
		JButton btnEditMeterReading = new JButton("Edit Meter Reading");
		btnEditMeterReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showCDMeterScreen();
			}
		});
		btnEditMeterReading.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditMeterReading.setBounds(214, 350, 207, 29);
		add(btnEditMeterReading);
		
		JButton btnDisplayBill = new JButton("Display Bill");
		btnDisplayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showCBillScreen(index);
			}
		});
		btnDisplayBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplayBill.setBounds(186, 391, 139, 29);
		add(btnDisplayBill);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(109, 51, 69, 20);
		add(lblName);
		
		JLabel lblHouseUnit = new JLabel("House Unit:");
		lblHouseUnit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHouseUnit.setBounds(109, 68, 95, 20);
		add(lblHouseUnit);
		
		JLabel lblName1= new JLabel("Name");
		lblName1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName1.setBounds(167, 51, 69, 20);
		add(lblName1);

		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUnit.setBounds(209, 68, 69, 20);
		add(lblUnit);
		
		
		ImageIcon utilities = new ImageIcon("icons8-utility-64.png"); //create imageicon for utilities
		JLabel lblUtilitiesLabel = new JLabel("(icon here)");
		lblUtilitiesLabel.setBounds(10, 45, 69, 68);
		lblUtilitiesLabel.setIcon(utilities);
		add(lblUtilitiesLabel);
		
		ImageIcon water = new ImageIcon("water-50.png"); //create imageicon for water
		JLabel lblWaterIcon = new JLabel("(water 50x50)");
		lblWaterIcon.setBounds(10, 125, 52, 56);
		lblWaterIcon.setIcon(water);//set icon
		add(lblWaterIcon);
		
		ImageIcon gas = new ImageIcon("gas-50.png"); //create imageicon for gas
		JLabel lblGasIcon = new JLabel("(gas 50x50)");
		lblGasIcon.setBounds(10, 190, 46, 49);
		lblGasIcon.setIcon(gas);//set icon
		add(lblGasIcon);
		
		ImageIcon elec = new ImageIcon("Electricity-64.png"); //create imageicon for electricity
		JLabel lblElecIcon = new JLabel("(elec 64x64)");
		lblElecIcon.setBounds(10, 241, 69, 68);
		lblElecIcon.setIcon(elec);
		add(lblElecIcon);
		
		
		ImageIcon stats2019 = new ImageIcon("AverageMonthlyBill2019.png"); // create imageicon for stats2019
		
		JButton btnViewStats = new JButton("View local average");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, null, "Local Average for 2019", JOptionPane.INFORMATION_MESSAGE, stats2019);
			}
		});
		btnViewStats.setBounds(175, 319, 163, 19);
		add(btnViewStats);
		
		JLabel lblMonth = new JLabel("(Month here)");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonth.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonth.setBounds(165, 92, 113, 21);
		add(lblMonth);
		
		JLabel lblMonthLabel = new JLabel("Month:");
		lblMonthLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonthLabel.setBounds(93, 92, 69, 21);
		add(lblMonthLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showLoginScreen();
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		add(btnLogout);
		
		JButton btnGTSlider = new JButton("find out more about CO2 emissions");
		btnGTSlider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showCSliderScreen();
			}
		});
		btnGTSlider.setBounds(109, 288, 294, 21);
		add(btnGTSlider);
		
		
		cust = main.getController().getAllCustomer();
		for(int i=0; i<cust.length; i++)
		{
			Customer ct= cust[i];
			a = ct.getName();
			b = ct.getUnit();
			c = ct.getMonth();
			lblName1.setText(a);
			lblUnit.setText(b);
			lblMonth.setText(c);
		}
	}
}
