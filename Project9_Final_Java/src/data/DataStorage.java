package data;

import java.util.Arrays;
import java.util.Vector;


public class DataStorage {
	
	public Vector<meterPrice> price = new Vector<meterPrice>();
	public Vector<serviceCharge> charge = new Vector<serviceCharge>();
	public Vector<Customer> cust = new Vector<Customer>();
	Vector<User> storage = new Vector<User>();
	public Vector<meterReading> meterRead = new Vector<meterReading>();
	
	private int index;

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
		System.out.println("User Name: "+u.getUName());
		System.out.println("Password: "+u.getUPassword());
		System.out.println("Type: "+u.getType());
		this.storage.add(u); 
	 }


	public User getPwd(String n) { 
		for(int i=0; i<storage.size(); i++)	{
			User temp = storage.get(i);
			if (temp.getUName().equals(n)){
			return temp;
			}
		}
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
	
	//Nagul DataStorage
	public void storeCustomer(Customer c) {
		System.out.println("Name: " + c.getName());
		System.out.println("House Unit:" + c.getUnit());
		System.out.println("Month: " + c.getMonth());
		System.out.println("Water Bill: " + c.getWBill());
		System.out.println("Gas Bill: " + c.getGBill());
		System.out.println("Electricity Bill: " + c.getEBill());
		System.out.println("Total Bill: " + c.getTBill());
		this.cust.add(c);
	}

	public Customer[] getAllCustomer() {
		Customer[] custArr = new Customer[this.cust.size()];
		this.cust.toArray(custArr);
		return custArr;
	}
	
	public void storeMeterReading(meterReading mR){
		this.meterRead.add(mR);
	}

	public void deletemeterReading(int index, meterReading mR) {
		this.meterRead.remove(index);
		this.meterRead.remove(mR);
	}
	
	public meterReading[] getmeterReading(){
		meterReading[] mrArr = new meterReading[this.meterRead.size()];
		this.meterRead.toArray(mrArr);
		return mrArr;
	}

	public void editMeterReading(int index, meterReading newMR) {
		this.meterRead.setElementAt(newMR, index);
		
	}
	
		

	public void storeCalcBill(Customer c) {
		this.cust.add(c);
		this.cust.remove(0);
		System.out.println("Vector size: " + cust.size());
	}


}