package controller;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import data.Customer;
import data.meterPrice;
import data.meterReading;
import data.serviceCharge;
import gui.CBillScreen;
import gui.CDMeterScreen;
import gui.CEditMeterScreen;
import gui.CMeterScreen;
import gui.CRegisterScreen;
import gui.CSliderScreen;
import gui.LoginScreen;
import gui.RegisterScreen;
import gui.SBillScreen;
import gui.SDPriceScreen;
import gui.SDServiceScreen;
import gui.SEditPriceScreen;
import gui.SEditServiceScreen;
import gui.SMainScreen;
import gui.SPriceScreen;
import gui.SServiceScreen;

public class MainFrame extends JFrame{
	
	private CardLayout card;
	private Controller cont;
	private MainFrame()
	{
		this.setTitle("Utility Billing System");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.card = new CardLayout();
		this.setLayout(this.card);
		this.cont = new Controller();
		this.showLoginScreen();
		this.setVisible(true);
		
		ImageIcon icon = new ImageIcon("SoftwareIcon.png"); //create an ImageIcon
		this.setIconImage(icon.getImage()); //change icon of frame
	}



	public Controller getController() {
	 	 return this.cont; 
	}
	
	//Register & Login Staff/Customer screens
	public void showRegisterScreen() { 
		RegisterScreen p1 = new RegisterScreen(this);
		this.add(p1,"AddUser");
		this.card.show(this.getContentPane(), "AddUser");
	 }
	public void showCRegisterScreen(){
		CRegisterScreen p2 = new CRegisterScreen(this);
		this.add(p2, "CRegister");
		this.card.show(this.getContentPane(), "CRegister");
	}
	
	public void showLoginScreen() { 
		LoginScreen p2 = new LoginScreen(this);
		this.add(p2, "LoginUser");
		this.card.show(this.getContentPane(), "LoginUser");
	 }

	//SMain, SPrice, SService, SDPrice, SDService,SEditPrice, SEditService, SBill screens
	public void showSMainScreen() { 
		SMainScreen p3 = new SMainScreen(this);
		this.add(p3, "SMain");
		this.card.show(this.getContentPane(), "SMain");
	 } 
	
	public void showSPriceScreen() { 
		SPriceScreen p4 = new SPriceScreen(this);
		this.add(p4, "SMeter");
		this.card.show(this.getContentPane(),"SMeter");
	 }

	public void showSServiceScreen() { 
		SServiceScreen p5 = new SServiceScreen(this);
		this.add(p5, "SService");
		this.card.show(this.getContentPane(), "SService");
	 }

	public void showSDPriceScreen() { 
		SDPriceScreen p6 = new SDPriceScreen(this);
		this.add(p6, "SDPrice");
		this.card.show(this.getContentPane(), "SDPrice");
	 }

	public void showSEditPriceScreen(int ind, meterPrice pri) { 
		SEditPriceScreen p7 = new SEditPriceScreen(this, ind, pri);
		this.add(p7, "SEditPrice");
		this.card.show(this.getContentPane(), "SEditPrice");
	 }
	public void showSDServiceScreen()
	{
		SDServiceScreen p8 = new SDServiceScreen(this);
		this.add(p8, "SDService");
		this.card.show(this.getContentPane(), "SDService");
	}
	
	public void showSEditServiceScreen(int ind, serviceCharge sch)
	{
		SEditServiceScreen p9 = new SEditServiceScreen(this, ind, sch);
		this.add(p9, "SEditService");
		this.card.show(this.getContentPane(), "SEditService");
	}

	public void showSBillScreen()
	{
		SBillScreen p10 = new SBillScreen(this);
		this.add(p10, "SBill");
		this.card.show(this.getContentPane(), "SBill");
	}
	
	//CMeter, CDMeter, CEditMeter, CBill,CSlider screens
	public void showCMeterScreen(int index, Customer cu) { 
		CMeterScreen p11 = new CMeterScreen(this, index, cu);
		this.add(p11, "CMeter");
		this.card.show(this.getContentPane(), "CMeter");
	 }
	public void showCDMeterScreen(){
		CDMeterScreen p12 = new CDMeterScreen(this);
		this.add(p12, "CDMeter");
		this.card.show(this.getContentPane(), "CDMeter");
	}
	
	public void showCEditMeterScreen(int index, meterReading mR){
		CEditMeterScreen p13 = new CEditMeterScreen(this, index, mR);
		this.add(p13, "CEditMeter");
		this.card.show(this.getContentPane(), "CEditMeter");
	}
	
	public void showCBillScreen(int index)
	{
		CBillScreen p14 = new CBillScreen(this,index);
		this.add(p14, "CBill");
		this.card.show(this.getContentPane(), "CBill");
	}
	
	public void showCSliderScreen()
	{
		CSliderScreen p15 = new CSliderScreen(this);
		this.add(p15, "CSlider");
		this.card.show(this.getContentPane(), "CSlider");
	}
	


	public static void main(String args[]) { 
		MainFrame bill = new MainFrame();
	 }


}
