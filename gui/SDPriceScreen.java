package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.meterPrice;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SDPriceScreen extends JPanel{
	
	private JTable table;
	private MainFrame main;
	private DefaultTableModel model;
	private meterPrice[] price;
	
	public SDPriceScreen(MainFrame main) {

		setLayout(null);
		this.main = main;
		this.model = new DefaultTableModel();
		this.table = new JTable(model);
		
		model.addColumn("Water");
		model.addColumn("Gas");
		model.addColumn("Electricity");
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(76, 61, 266, 129);
		add(scrollPane);
		
		this.populatePriceList();
		
		JLabel lblEditMeterPrice = new JLabel(" Meter Price Table");
		lblEditMeterPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditMeterPrice.setBounds(135, 37, 164, 20);
		add(lblEditMeterPrice);
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRow = table.getSelectedRow();
				System.out.println("Selected row is: " + numRow);
				
				if (numRow == -1)
					return;
				meterPrice pri = price[numRow];
				main.showSEditPriceScreen(numRow, pri);
			}
		});
		btnUpdate.setBounds(76, 206, 115, 29);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				int numRow = table.getSelectedRow();
				if (numRow == -1)
					return;
				model.removeRow(numRow);
				meterPrice m = price[numRow];
				main.getController().deletePrice(numRow, m);
			}
		});
		btnDelete.setBounds(227, 206, 115, 29);
		add(btnDelete);
		
		JButton btnBackToSet = new JButton("Back to Set");
		btnBackToSet.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSMeterScreen();
			}
		});
		btnBackToSet.setBounds(64, 244, 144, 29);
		add(btnBackToSet);
	}

	private void populatePriceList() {
		this.price = this.main.getController().getAllMeterPrice();
		for (int i = 0; i<price.length; i++)
		{
			meterPrice op = price[i];
			model.insertRow(table.getRowCount(), new Object[] {op.getWPrice(), op.getGPrice(), op.getEPrice() });
			this.table.setModel(model);
		}
		
	}
}
