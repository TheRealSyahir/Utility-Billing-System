package controller;

import java.awt.CardLayout;

import javax.swing.JFrame;

import data.meterPrice;
import data.serviceCharge;
import gui.LoginScreen;
import gui.RegisterScreen;
import gui.SDPriceScreen;
import gui.SDServiceScreen;
import gui.SEditPriceScreen;
import gui.SEditServiceScreen;
import gui.SMainScreen;
import gui.SMeterScreen;
import gui.SServiceScreen;

public class MainFrame extends JFrame{
	
	private CardLayout card;
	private Controller cont;
	private MainFrame()
	{
		this.setTitle("Utility Billing System");
		this.setSize(450,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.card = new CardLayout();
		this.setLayout(this.card);
		this.cont = new Controller();
		this.showSMainScreen();
		this.setVisible(true);
	}


	public SDPriceScreen seditpricescreen;
	public SMainScreen smainscreen;
	public SEditServiceScreen seditservicescreen;
	public SMeterScreen smeterscreen;
	public RegisterScreen registerscreen;
	public SServiceScreen sservicescreen;
	public LoginScreen loginscreen;


	public SMainScreen getSmainscreen() {
	 	 return smainscreen; 
	}

	public void setSmainscreen(SMainScreen smainscreen) { 
		 this.smainscreen = smainscreen; 
	}

	public SEditServiceScreen getSeditservicescreen() {
	 	 return seditservicescreen; 
	}

	public void setSeditservicescreen(SEditServiceScreen seditservicescreen) { 
		 this.seditservicescreen = seditservicescreen; 
	}

	public SMeterScreen getSmeterscreen() {
	 	 return smeterscreen; 
	}

	public void setSmeterscreen(SMeterScreen smeterscreen) { 
		 this.smeterscreen = smeterscreen; 
	}

	public Controller getController() {
	 	 return this.cont; 
	}

	//Register & Login screens
	public RegisterScreen getRegisterscreen() {
	 	 return registerscreen; 
	}

	public void setRegisterscreen(RegisterScreen registerscreen) { 
		 this.registerscreen = registerscreen; 
	}

	public SServiceScreen getSservicescreen() {
	 	 return sservicescreen; 
	}

	public void setSservicescreen(SServiceScreen sservicescreen) { 
		 this.sservicescreen = sservicescreen; 
	}

	public LoginScreen getLoginscreen() {
	 	 return loginscreen; 
	}

	public void setLoginscreen(LoginScreen loginscreen) { 
		 this.loginscreen = loginscreen; 
	}

	public void showRegisterScreen() { 
		// TODO Auto-generated method
	 }
	
	public void showLoginScreen() { 
		// TODO Auto-generated method
	 }

	
	
	//SMain, SAMeter, SAService, SDPrice, SDService,SEditPrice, SEditService screens
	public void showSMeterScreen() { 
		SMeterScreen p2 = new SMeterScreen(this);
		this.add(p2, "Panel2");
		this.card.show(this.getContentPane(),"Panel2");
	 }


	public void showSServiceScreen() { 
		SServiceScreen p3 = new SServiceScreen(this);
		this.add(p3, "Panel3");
		this.card.show(this.getContentPane(), "Panel3");
	 }


	public void showSDPriceScreen() { 
		SDPriceScreen p4 = new SDPriceScreen(this);
		this.add(p4, "Panel4");
		this.card.show(this.getContentPane(), "Panel4");
	 }

	public void showSEditPriceScreen(int ind, meterPrice pri) { 
		SEditPriceScreen p5 = new SEditPriceScreen(this, ind, pri);
		this.add(p5, "Panel5");
		this.card.show(this.getContentPane(), "Panel5");
	 }
	public void showSDServiceScreen()
	{
		SDServiceScreen p6 = new SDServiceScreen(this);
		this.add(p6, "Panel6");
		this.card.show(this.getContentPane(), "Panel6");
	}
	
	public void showSEditServiceScreen(int ind, serviceCharge sch)
	{
		SEditServiceScreen p7 = new SEditServiceScreen(this, ind, sch);
		this.add(p7, "Panel7");
		this.card.show(this.getContentPane(), "Panel7");
	}

	public void showSMainScreen() { 
		SMainScreen p1 = new SMainScreen(this);
		this.add(p1, "Panel1");
		this.card.show(this.getContentPane(),"Panel1");
	 } 
	
	public static void main(String args[]) { 
		MainFrame bill = new MainFrame();
	 }


}
