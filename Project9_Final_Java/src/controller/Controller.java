package controller;

import javax.swing.JOptionPane;
import data.Customer;
import data.DataStorage;
import data.User;
import data.meterPrice;
import data.meterReading;
import data.serviceCharge;

public class Controller {

	public DataStorage ds = new DataStorage();
	private String tt = "";
	private int index;
	public DataStorage getDatastorage() {
	 	 return ds; 
	}

	public void setDatastorage(DataStorage datastorage) { 
		 this.ds = datastorage; 
	}

	
	public void addUser(String n, String p, String t) { 
		User u = new User();
		u.setUName(n);
		u.setUPassword(p);
		u.setType(t);
		ds.storeUser(u);
	 }
	
	public boolean checkUser(String n, String p) { 
		String cc = "";

		User  t= ds.getPwd(n);
		if(t!=null){
			cc= t.getUPassword().toString();
			tt= t.getType().toString();
			System.out.println("Read from vector:"+tt);
		}
		else{
			cc="no object";
		}
		System.out.println("password is: "+cc);
		if(p.equals(cc) && tt.equals("Customer")){
			System.out.println("Right & type is:"+tt);
			String msg = "Successful"+"\n";
			JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
			return true;
			}
		else if(p.equals(cc) && tt.equals("Staff")){
			System.out.println("Right & type is:"+tt);
			String msg = "Successful"+"\n";
			JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
			return true;
			}
		else
		{
		System.out.println("Wrong");
		String msg = "Wrong user name or password"+"\n";
		JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
		return false;}
	}
		
	public String getTypeName(){
		return tt;
	}
	
	public void addserviceCharge(double wc, double gc, double ec) { 
		serviceCharge sc = new serviceCharge(wc, gc, ec);
		sc.setWCharge(wc);
		sc.setGCharge(gc);
		sc.setECharge(ec);
		this.ds.storeserviceCharge(sc);
		
	 }
	public serviceCharge[] getAllCharge() {
		return this.ds.getAllCharge();
	}

	public void addmeterPrice(double wp, double gp, double ep) { 
		meterPrice mp = new meterPrice(wp, gp, ep);
		mp.setWPrice(wp);
		mp.setGPrice(gp);
		mp.setEPrice(ep);
		this.ds.storemeterPrice(mp);
	 } 
	
	public meterPrice[] getAllMeterPrice()
	{
		return this.ds.getAllMeterPrice();
	}


	public void deletePrice(int numRow, meterPrice m) {
		this.ds.deletePrice(numRow, m);	
	}


	public void editPrices(int index, meterPrice newpri) {
		this.ds.editPrices(index, newpri);
	}


	public void editCharges(int index, serviceCharge newsch) {
		this.ds.editCharges(index, newsch);
		
	}


	public void deleteCharge(int numRow, serviceCharge s) {
		this.ds.deleteCharge(numRow, s);
		
	}
	
	
	public void addCustomer(String n, String u,String m, double wb, double gb, double eb, double tb){
		Customer c = new Customer(n,u,m,wb,gb,eb,tb);
		c.setName(n);
		c.setUnit(u);
		c.setMonth(m);
		c.setWBill(wb);
		c.setGBill(gb);
		c.setEBill(eb);
		c.setTBill(tb);
		this.ds.storeCustomer(c);
	}

	public Customer[] getAllCustomer(){
		return this.ds.getAllCustomer();
	}
	
	public void addmeterReading(double wt, double gs, double el) {
		meterReading mR = new meterReading(wt,gs,el);
		mR.setWat(wt);
		mR.setGas(gs);
		mR.setEle(el);
		this.ds.storeMeterReading(mR);
	}


	public void deletemeterReading(int index, meterReading mR) {
		this.ds.deletemeterReading(index,mR);
	}
	
	public meterReading[] getmeterReading(){
		return this.ds.getmeterReading();
	}

	public void editMeterReading(int index, meterReading newMR) {
		this.ds.editMeterReading(index, newMR);
		
	}

	public void calcBill(Customer c)
	
	{
		this.ds.cust.get(index).getName();
		this.ds.cust.get(index).getUnit();
		this.ds.cust.get(index).getMonth();
		
		this.ds.cust.get(index).setWBill(this.ds.meterRead.get(index).getWat() * this.ds.price.get(index).getWPrice() * this.ds.charge.get(index).getWCharge());
		this.ds.cust.get(index).setGBill(this.ds.meterRead.get(index).getGas() * this.ds.price.get(index).getGPrice() * this.ds.charge.get(index).getGCharge());
		this.ds.cust.get(index).setEBill(this.ds.meterRead.get(index).getEle() * this.ds.price.get(index).getEPrice() * this.ds.charge.get(index).getECharge());
		this.ds.cust.get(index).setTBill(this.ds.cust.get(index).getWBill() + this.ds.cust.get(index).getGBill() + this.ds.cust.get(index).getEBill());
		this.ds.storeCalcBill(c);
	}


}