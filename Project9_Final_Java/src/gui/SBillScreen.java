package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Customer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SBillScreen extends JPanel{
	private JTable table;
	private MainFrame main;
	private DefaultTableModel model;
	private Customer[] cust;
	private int index;
	private JTextArea textArea;
	private double ttb = 0;
	private JLabel lblTotal;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public SBillScreen(MainFrame main) {
		this.main = main;
		this.setSize(450,530);
		main.setSize(450,530);
		this.model = new DefaultTableModel();
		
		cust = main.getController().getAllCustomer();
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(67, 283, 328, 186);
		add(scrollPane_1);
		
		this.textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		this.table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if (index ==-1)
					return;
				Customer c = cust[index];
				textArea.setText("Name:" + c.getName() + "\n" + "Unit:" + c.getUnit() + "\n" + "Month:" + c.getMonth()
								+ "\n" +  "Water Bill:" + df.format(c.getWBill()) + "\n" + "Gas Bill:" + df.format(c.getGBill())
								+ "\n" + "Electricity Bill:" + df.format(c.getEBill()) + "\n" + "Total Customer Bill:" + df.format(c.getTBill())
								);
			}
		});
		
		
		model.addColumn("Customer");
		model.addColumn("House Unit");
		model.addColumn("Month");
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(67, 63, 324, 98);
		add(scrollPane);
		this.populateCustomerList();
		
		JButton btnBackToStaff = new JButton("Back to Staff Main");
		btnBackToStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSMainScreen();
			}
		});
		btnBackToStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToStaff.setBounds(125, 177, 209, 29);
		add(btnBackToStaff);
		
		JLabel lblDatabaseOfCustomers = new JLabel("Database Of Customers");
		lblDatabaseOfCustomers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatabaseOfCustomers.setBounds(137, 27, 198, 20);
		add(lblDatabaseOfCustomers);
		
		JLabel lblTotalCustomersBills = new JLabel("Total Customers Bills:");
		lblTotalCustomersBills.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalCustomersBills.setBounds(67, 232, 179, 20);
		add(lblTotalCustomersBills);
		
		this.CalcTBill();
		this.lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(249, 232, 69, 20);
		add(lblTotal);
		lblTotal.setText(String.valueOf(this.ttb));
		
		
		
	}
	private void populateCustomerList(){
		this.cust = main.getController().getAllCustomer();
		for(int i =0; i<cust.length; i++){
			Customer c = cust[i];
			model.insertRow(table.getRowCount(), new Object[] {c.getName(), c.getUnit(), c.getMonth()});
			this.table.setModel(model);
		}
	}
	
	private double CalcTBill(){
		this.cust = this.main.getController().getAllCustomer();
		Customer cu = cust[index];
		for (int i =0; i<cust.length; i++)
		{
			ttb = ttb + cu.getTBill();	
			System.out.println("Total bills:" + ttb);
		}
		return ttb;
	}
	
}
