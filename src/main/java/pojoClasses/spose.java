package pojoClasses;

public class spose {

	String sname;
	int phoneNo;
	String semail;
	String address;
	public spose(String sname, int phoneNo, String semail, String address) {
		
		this.sname = sname;
		this.phoneNo = phoneNo;
		this.semail = semail;
		this.address = address;
	}
	public spose(){
		
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

	
	
}
