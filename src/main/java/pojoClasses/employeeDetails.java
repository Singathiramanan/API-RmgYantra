package pojoClasses;

public class employeeDetails {
	String ename;
	String eid;
	int phoneNo;
	String email;
	String address;
	
	public employeeDetails(String ename, String eid, int phoneNo, String email, String address) {
		this.ename = ename;
		this.eid = eid;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}
	public employeeDetails(){
		
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
