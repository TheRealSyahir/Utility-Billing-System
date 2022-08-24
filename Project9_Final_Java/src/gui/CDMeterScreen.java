package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Customer;
import data.meterReading;

public class CDMeterScreen extends JPanel
{
	  private JTable table;
	  private MainFrame main;
	  private DefaultTableModel model;
	  private meterReading[] meterRead;
	  private int index;
	  private Customer cust;
	  
	  public CDMeterScreen(MainFrame main) {

	    setLayout(null);
	    this.main = main;
	    this.setVisible(true);
	    this.setSize(450, 400);
	    main.setSize(450, 400);
	    this.model = new DefaultTableModel();
	    this.table = new JTable(model);
	    
	    model.addColumn("Water");
	    model.addColumn("Gas");
	    model.addColumn("Electricity");
	        
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(26, 55, 390, 166);
	    add(scrollPane);
	    
	    this.populatePriceList();
	    
	    JLabel lblEditMeterReading = new JLabel("Select Meter Reading");
	    lblEditMeterReading.setHorizontalAlignment(SwingConstants.CENTER);
	    lblEditMeterReading.setFont(new Font("Dialog", Font.BOLD, 18));
	    lblEditMeterReading.setBounds(6, 23, 438, 20);
	    add(lblEditMeterReading);
	    
	    JButton btnEdit = new JButton("Edit");
	    btnEdit.setFont(new Font("Dialog", Font.BOLD, 16));
	    btnEdit.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        int index = table.getSelectedRow();
	        if (index == -1)
	          return;
	        meterReading mR = meterRead[index];
	        main.showCEditMeterScreen(index, mR);
	      }
	    });
	    btnEdit.setBounds(109, 250, 85, 29);
	    add(btnEdit);
	    
	    JButton btnDelete = new JButton("Delete");
	    btnDelete.setFont(new Font("Dialog", Font.BOLD, 16));
	    btnDelete.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {    
	        int index = table.getSelectedRow();
	        if (index == -1)
	          return;
	        model.removeRow(index);
	        meterReading m = meterRead[index];
	        main.getController().deletemeterReading(index, m);
	      }
	    });
	    btnDelete.setBounds(248, 250, 92, 29);
	    add(btnDelete);
	    
	    JButton btnBackToMain = new JButton("Back To Customer Main");
	    btnBackToMain.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		main.showCMeterScreen(index,cust);
	    	}
	    });
	    btnBackToMain.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnBackToMain.setBounds(109, 295, 231, 29);
	    add(btnBackToMain);
	  }

	  private void populatePriceList() 
	  {
	    this.meterRead = this.main.getController().getmeterReading();
	    for (int i = 0; i<meterRead.length; i++)
	    {
	      meterReading mrArr = meterRead[i];
	      model.insertRow(table.getRowCount(), new Object[] {mrArr.getWat(), mrArr.getGas(), mrArr.getEle()});
	      this.table.setModel(model);
	    }
	    
	  }
}
