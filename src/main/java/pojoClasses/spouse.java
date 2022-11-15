package pojoClasses;

public class spouse {
	String sname;
	int phoneNo;
	String semail;
	String address;
	Child1 ch1;
	Child2 ch2;
	public spouse(String sname, int phoneNo, String semail, String address, Child1 ch1, Child2 ch2) {
		super();
		this.sname = sname;
		this.phoneNo = phoneNo;
		this.semail = semail;
		this.address = address;
		this.ch1 = ch1;
		this.ch2 = ch2;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Child1 getCh1() {
		return ch1;
	}
	public void setCh1(Child1 ch1) {
		this.ch1 = ch1;
	}
	public Child2 getCh2() {
		return ch2;
	}
	public void setCh2(Child2 ch2) {
		this.ch2 = ch2;
	}
	
}
