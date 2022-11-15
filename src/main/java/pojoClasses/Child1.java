package pojoClasses;

public class Child1 {
	String cname;
	int cage;
	String cadress;
	public Child1(String cname, int cage, String cadress) {
		super();
		this.cname = cname;
		this.cage = cage;
		this.cadress = cadress;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCadress() {
		return cadress;
	}
	public void setCadress(String cadress) {
		this.cadress = cadress;
	}
	
}
