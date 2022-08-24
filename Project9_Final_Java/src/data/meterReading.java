package data;

public class meterReading {
	
	private double Gas;
	private double Wat;
	private double Ele;
	
	public meterReading(double wt, double gs, double el) {
		this.Wat = wt;
		this.Gas = gs;
		this.Ele = el;
	}
	
	public double getGas() {
	 	 return Gas; 
	}
	
	public void setGas(double Gas) { 
		 this.Gas = Gas; 
	}
	
	public double getWat() {
	 	 return Wat; 
	}
	
	public void setWat(double Wat) { 
		 this.Wat = Wat; 
	}
	
	public double getEle() {
	 	 return Ele; 
	}
	
	public void setEle(double Ele) { 
		 this.Ele = Ele; 
	} 

}
