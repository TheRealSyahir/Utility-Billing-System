package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.serviceCharge;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SDServiceScreen extends JPanel{
	private JTable table;
	private MainFrame main;
	private DefaultTableModel model;
	private serviceCharge[] charge;
	
	public SDServiceScreen(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.model = new DefaultTableModel();
		this.table = new JTable(model);
		
		model.addColumn("Water");
		model.addColumn("Gas");
		model.addColumn("Electricity");
		
		
		JLabel lblServiceChargeTable = new JLabel("Service Charge Table");
		lblServiceChargeTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServiceChargeTable.setBounds(131, 16, 173, 20);
		add(lblServiceChargeTable);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(75, 39, 294, 130);
		add(scrollPane);
		this.populateChargeList();

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numRow = table.getSelectedRow();
				System.out.println("Selected row is: " + numRow);
				
				if (numRow == -1)
					return;
				serviceCharge sch = charge[numRow];
				main.showSEditServiceScreen(numRow, sch);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit.setBounds(72, 195, 115, 29);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRow = table.getSelectedRow();
				if (numRow == -1)
					return;
				model.removeRow(numRow);
				serviceCharge s = charge[numRow];
				main.getController().deleteCharge(numRow, s);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(231, 195, 115, 29);
		add(btnDelete);
		
		JButton btnBack = new JButton("Back to Set");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showSServiceScreen();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(62, 236, 141, 29);
		add(btnBack);
	}

	private void populateChargeList() {
		this.charge = this.main.getController().getAllCharge();
		for (int i=0; i<charge.length; i++)
		{
			serviceCharge sc = charge[i];
			model.insertRow(table.getRowCount(), new Object[] {sc.getWCharge(), sc.getGCharge(), sc.getECharge() });
			this.table.setModel(model);
		}
		
	}
}
