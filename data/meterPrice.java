package data;

public class meterPrice {


	private double gPrice;
	private double ePrice;
	private double wPrice;

	public meterPrice(double wp, double gp, double ep) {
		this.wPrice = wp;
		this.gPrice = gp;
		this.ePrice = ep;
	}

	public double getGPrice() {
	 	 return gPrice; 
	}

	public void setGPrice(double gPrice) { 
		 this.gPrice = gPrice; 
	}

	public double getEPrice() {
	 	 return ePrice; 
	}

	public void setEPrice(double ePrice) { 
		 this.ePrice = ePrice; 
	}

	public double getWPrice() {
	 	 return wPrice; 
	}

	public void setWPrice(double wPrice) { 
		 this.wPrice = wPrice; 
	} 

}
