package controller;

import data.DataStorage;
import data.meterPrice;
import data.serviceCharge;

public class Controller {


	public DataStorage ds = new DataStorage();


	public DataStorage getDatastorage() {
	 	 return ds; 
	}


	public void setDatastorage(DataStorage datastorage) { 
		 this.ds = datastorage; 
	}


	public void addUser(String t, String p, String n) { 
		// TODO Auto-generated method
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



	public boolean checkUser(String n, String p) { 
		// TODO Auto-generated method
		return false;
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




}
