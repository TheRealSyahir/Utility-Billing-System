package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.MainFrame;
import data.Customer;
import data.meterReading;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class CSliderScreen extends JPanel implements ChangeListener{
	
	private MainFrame main;
	private meterReading[] meterRead;
	private double co2;
	private double kWH;
	private double Elec;
	private double gas;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private int index;
	private Customer cust;
	
	
	public CSliderScreen(MainFrame main){
		this.main = main;
		this.setSize(450, 300);
		main.setSize(460, 390);
		
		setLayout(null);
		main.setVisible(true);
		
		JLabel lblKWH = new JLabel("(kWH used here)");
		lblKWH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKWH.setHorizontalAlignment(SwingConstants.CENTER);
		lblKWH.setBounds(20, 21, 420, 27);
		add(lblKWH);
		
		JSlider slider = new JSlider(0,1000, 100);
		slider.setForeground(new Color(51, 51, 255));
		//slider.setSnapToTicks(true);
		slider.setMinimum(0);
		slider.setMaximum(1000);
		slider.setBounds(10, 59, 430, 66);
		
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(100);
		
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(250);
		
		slider.setPaintLabels(true);
		slider.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		add(slider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 136, 403, 66);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		
		kWH = slider.getValue();
		co2 = (slider.getValue() * 0.408);
		
		textArea.setText("When " + kWH + "(kWh) of energy is wasted," + "\n" + df.format(co2) + "(kg) of CO2 emmision is produced");
		lblKWH.setText("kWH used =" + kWH); // so that it starts with the initial value
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				co2 = (slider.getValue() * 0.408); // values retrived from https://www.ema.gov.sg/singapore-energy-statistics/Ch02/index2
				kWH = slider.getValue();
				
				lblKWH.setText("kWH used =" + kWH); // update the label if slider moved
				textArea.setText("When " + kWH + "(kWh) of energy is wasted,\n" + df.format(co2) + "(kg) of CO2 emmision is produced");
			}
		});
		
		
		this.meterRead = this.main.getController().getmeterReading();
		meterReading mrArr = meterRead[meterRead.length-1];
		Elec = mrArr.getEle();
		gas = mrArr.getGas();
		
		JButton btnCustValue = new JButton("Whats my value?");
		btnCustValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kWH = Elec + gas;
				co2 = 0.408;
				textArea.setText("Your energy usage of "+ kWH + "(kWH) will produce\n" + df.format(kWH * co2)+ "(kg) of CO2 emmission");
				slider.setValue((int) kWH);
			}
		});
		btnCustValue.setBounds(125, 213, 178, 23);
		add(btnCustValue);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showCMeterScreen(index,cust);
			}
		});
		btnBack.setBounds(170, 266, 89, 23);
		add(btnBack);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
