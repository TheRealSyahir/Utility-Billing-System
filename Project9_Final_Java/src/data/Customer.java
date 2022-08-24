package data;

public class Customer {
	private String Name;
	private String Unit;
	private String Month;
	private double wBill;
	private double gBill;
	private double eBill;
	private double tBill;
	
	public double getTBill()
	{
		return tBill;
	}
	
	public void setTBill(double tBill)
	{
		this.tBill=tBill;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getUnit()
	{
		return Unit;
	}
	public void setUnit(String Unit)
	{
		this.Unit = Unit;
		
	}
	public Customer(String n, String u,String m, double wb, double gb, double eb,double tb)
	{
		this.Name = n;
		this.Unit = u;
		this.Month = m;
		this.wBill = wb;
		this.gBill = gb;
		this.eBill = eb;
		this.tBill = tb;
	}
	public String getMonth(){
		return Month;
	}
	public void setMonth(String Month){
		this.Month = Month;
	}
	
	public double getGBill(){
		return gBill;
	}
	public void setGBill(double gBill){
		
		this.gBill = gBill;
	}
	public double getWBill(){
		return wBill;
	}
	public void setWBill(double wBill){
		this.wBill = wBill;
	}
	public double getEBill(){
		return eBill;
	}
	public void setEBill(double eBill){
		this.eBill = eBill;
	}
}