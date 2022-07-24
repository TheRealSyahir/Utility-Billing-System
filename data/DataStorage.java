package data;

import java.util.Vector;

public class DataStorage {

	private Vector<meterPrice> price = new Vector<meterPrice>();
	private Vector<serviceCharge> charge = new Vector<serviceCharge>();

	public void storemeterPrice(meterPrice mp) { 
		this.price.add(mp);
		System.out.println("Water Meter Price: " + mp.getWPrice());
		System.out.println("Gas Meter Price: " + mp.getGPrice());
		System.out.println("Electricity Meter Price: " + mp.getEPrice());
	 }
	
	public meterPrice[] getAllMeterPrice()
	{
		meterPrice[] opArr = new meterPrice[this.price.size()];
		this.price.toArray(opArr);
		return opArr;
	}
	
	public void deletePrice(int numRow, meterPrice m) {
		this.price.remove(numRow);
		this.price.remove(m);
	} 

	public void storeserviceCharge(serviceCharge sc) { 
		this.charge.add(sc);
		System.out.println("Water Service Charge: " + sc.getWCharge());
		System.out.println("Gas Service Charge: " + sc.getGCharge());
		System.out.println("Electricity Service Charge: " + sc.getECharge());
	 }
	
	public serviceCharge[] getAllCharge() {
		serviceCharge[] scArr = new serviceCharge[this.charge.size()];
		this.charge.toArray(scArr);
		return scArr;
	}

	public void storeUser(User u) { 
		// TODO Auto-generated method
	 }


	public User getPwd(String n) { 
		// TODO Auto-generated method
		return null;
	 }

	public void editPrices(int index, meterPrice newpri) {
		this.price.setElementAt(newpri, index);
		
	}

	public void editCharges(int index, serviceCharge newsch) {
		this.charge.setElementAt(newsch, index);
		
	}

	public void deleteCharge(int numRow, serviceCharge s) {
		this.charge.remove(numRow);
		this.charge.remove(s);
	}




}
