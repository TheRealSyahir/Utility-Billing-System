package data;

public class serviceCharge {


	private double wCharge;
	private double eCharge;
	private double gCharge;
	
	public serviceCharge(double wc, double gc, double ec)
	{
		this.wCharge = wc;
		this.gCharge = gc;
		this.eCharge = ec;
	}

	public double getWCharge() {
	 	 return wCharge; 
	}

	public void setWCharge(double wCharge) { 
		 this.wCharge = wCharge; 
	}

	public double getECharge() {
	 	 return eCharge; 
	}

	public void setECharge(double eCharge) { 
		 this.eCharge = eCharge; 
	}

	public double getGCharge() {
	 	 return gCharge; 
	}

	public void setGCharge(double gCharge) { 
		 this.gCharge = gCharge; 
	} 

}
