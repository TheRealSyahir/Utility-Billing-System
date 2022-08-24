package gui;

//import java.time.LocalDate;
//import java.time.Month;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;

import data.meterReading;
import data.Customer;
import data.meterPrice;
import data.serviceCharge;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class CBillScreen extends JPanel
{
	private MainFrame main;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JTable table4;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private DefaultTableModel model4;
	
	
	private String a="";
	private String b ="";
	private String d = "";
	private String total;
	private double sum = 0;
	
	private double tb = 0;
	private int index;
	
	private meterReading[] meterRead;
	private meterPrice[] price;
	private serviceCharge[] charge;
	private Customer[] cust;
	private Customer cus;
	
	public CBillScreen(MainFrame main, int index) {
		
		setLayout(null);
		this.main=main;
		this.setVisible(true);
		this.setSize(460,350);
		main.setSize(460,350);
		this.model1 = new DefaultTableModel();
		this.model2 = new DefaultTableModel();
		this.model3 = new DefaultTableModel();
		this.model4 = new DefaultTableModel();
		this.table1 = new JTable(model1);
		this.table2 = new JTable(model2);
		this.table3 = new JTable(model3);
		this.table4 = new JTable(model4);
		
		model1.addColumn("Water(cu M)");
		model1.addColumn("Gas(kWh)");
		model1.addColumn("Electricity(kWh)");
		
		model2.addColumn("Water($)");
		model2.addColumn("Gas($)");
		model2.addColumn("Electricity($)");
		
		model3.addColumn("Water(%)");
		model3.addColumn("Gas(%)");
		model3.addColumn("Electricity(%)");
		
		model4.addColumn("Water($)");
		model4.addColumn("Gas($)");
		model4.addColumn("Electricity($)");
		
		JLabel lblCustomerBillingSystem = new JLabel("Customer Billing System");
		lblCustomerBillingSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerBillingSystem.setBounds(112, 16, 227, 20);
		add(lblCustomerBillingSystem);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(15, 48, 42, 20);
		add(lblName);
		
		JLabel lblHouseUnit = new JLabel("House Unit:");
		lblHouseUnit.setBounds(15, 79, 69, 20);
		add(lblHouseUnit);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(15, 110, 69, 20);
		add(lblMonth);
		
		JLabel lblMonthName = new JLabel("(Month here)");
		lblMonthName.setBounds(57, 113, 79, 14);
		add(lblMonthName);
		
		
		JLabel lblTotalUsage = new JLabel("Utility used");
		lblTotalUsage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalUsage.setBounds(15, 141, 130, 14);
		add(lblTotalUsage);
		
		JLabel lblName1 = new JLabel("(name here)");
		lblName1.setBounds(57, 51, 142, 14);
		add(lblName1);
		
		JLabel lblUnitNum = new JLabel("(Unit number here)");
		lblUnitNum.setBounds(79, 82, 99, 14);
		add(lblUnitNum);
		
		cust = main.getController().getAllCustomer();
		for(int i=0; i<cust.length; i++)
		{
			Customer ct= cust[i];
			a = ct.getName();
			b = ct.getUnit();
			d = ct.getMonth();
			lblName1.setText(a);
			lblUnitNum.setText(b);
			lblMonthName.setText(d);
		}
		
		// Show meter reading for each utility
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 160, 130, 41);
		add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		this.populateUtilityList();
		
		// Show meter price for each utility
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(155, 160, 130, 41);
		add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		this.populatePriceList();
		
		// Show service charges for each utility
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(295, 160, 130, 41);
		add(scrollPane_2);
		
		table3 = new JTable();
		scrollPane_2.setViewportView(table3);
		this.populateChargeList();
		
		// Show total price for each utility
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(112, 232, 227, 41);
		add(scrollPane_3);
		
		table4 = new JTable();
		scrollPane_3.setViewportView(table4);
		this.populateEachTotalList();
		
		
		
		JLabel lblServicePrice = new JLabel("Meter Price");
		lblServicePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicePrice.setBounds(155, 141, 130, 14);
		add(lblServicePrice);
		
		JLabel lblServiceCharges = new JLabel("Service Charges");
		lblServiceCharges.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceCharges.setBounds(295, 141, 130, 14);
		add(lblServiceCharges);
		
		this.getTBill();
		JLabel lblTotalAmount = new JLabel("$$$");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalAmount.setBounds(355, 81, 70, 14);
		add(lblTotalAmount);
		lblTotalAmount.setText("$" + String.valueOf(tb));
		
		JButton btnBacktomain = new JButton("Back");
		btnBacktomain.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				main.showCMeterScreen(index, cus);
			}
		});
		btnBacktomain.setBounds(10, 11, 74, 23);
		add(btnBacktomain);		
		
		JLabel lblEachTotal = new JLabel("Price for each utility");
		lblEachTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblEachTotal.setBounds(155, 212, 130, 14);
		add(lblEachTotal);
		
		JButton btnPayment = new JButton("Pay bill");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Confirm payment of $"+tb + "\n to PS Group", "Confirmation", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnPayment.setBounds(177, 284, 89, 23);
		add(btnPayment);
		
		JLabel lblNewLabel = new JLabel("Total Bill:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(278, 80, 79, 14);
		add(lblNewLabel);
		
		this.printLine();
		
	}

	private void populateUtilityList() 
	{
		this.meterRead = this.main.getController().getmeterReading();
		meterReading mrArr = meterRead[meterRead.length-1];
		model1.insertRow(table1.getRowCount(), new Object[] {mrArr.getWat(),mrArr.getGas(),mrArr.getEle()});
		this.table1.setModel(model1);
	}
	
	
	private void populatePriceList() {
		this.price = this.main.getController().getAllMeterPrice();
		meterPrice mpArr = price[price.length-1];
		model2.insertRow(table2.getRowCount(), new Object[] {mpArr.getWPrice(), mpArr.getGPrice(), mpArr.getEPrice()});
		this.table2.setModel(model2);
	}
	
	private void populateChargeList() {
		this.charge = this.main.getController().getAllCharge();
		serviceCharge scArr = charge[charge.length-1];
		model3.insertRow(table3.getRowCount(), new Object[] {scArr.getWCharge(), scArr.getGCharge(), scArr.getECharge()});
		this.table3.setModel(model3);
	}
	
	public void populateEachTotalList() {
		//Method works in getting Total Bill for individual customer but unsure how to save it into a created object
		
		/*this.meterRead = this.main.getController().getmeterReading();
		this.price = this.main.getController().getAllMeterPrice();
		this.charge = this.main.getController().getAllCharge();
		
		
		meterReading mrArr = meterRead[meterRead.length-1];
		meterPrice mpArr = price[price.length-1];
		serviceCharge scArr = charge[charge.length-1];
		
		model4.insertRow(table4.getRowCount(), new Object[] {
				(mrArr.getWat()*mpArr.getWPrice()*scArr.getWCharge()),
				(mrArr.getGas()*mpArr.getGPrice()*scArr.getGCharge()),
				(mrArr.getEle()*mpArr.getEPrice()*scArr.getECharge()) });
		this.table4.setModel(model4);
		
		//double sum = 0;
		double WaterTotal = mrArr.getWat()*mpArr.getWPrice()*scArr.getWCharge();
		double GasTotal = mrArr.getGas()*mpArr.getGPrice()*scArr.getGCharge();
		double ElecTotal = mrArr.getEle()*mpArr.getEPrice()*scArr.getECharge();
		
		sum = WaterTotal + GasTotal + ElecTotal;
		String total = String.valueOf(sum);
		System.out.println("Total is $" + total);*/
		
		this.cust = main.getController().getAllCustomer();
		for (int i =0; i<cust.length; i++)
		{
			Customer c = cust[i];
			model4.insertRow(table4.getRowCount(), new Object[] {c.getWBill(), c.getGBill(), c.getEBill()});
		}
		this.table4.setModel(model4);

	}
	
	private void printLine(){
		this.cust = this.main.getController().getAllCustomer();
		for (int i=0; i<cust.length; i++)
		{
			Customer c = cust[i];
			System.out.println(c.getName()+ " " + c.getUnit() + " " + c.getMonth() + " " + c.getWBill() + " "+ c.getGBill() + " " + c.getEBill() + " " + c.getTBill());
		}
	}
	
	private double getTBill(){
		this.cust = this.main.getController().getAllCustomer();
		Customer cu = cust[index];
		for (int i =0; i<cust.length; i++)
		{
			tb = cu.getTBill();
		}
		return tb;
		
	}
}
