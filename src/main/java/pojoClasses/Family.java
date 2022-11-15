package pojoClasses;

public class Family {
	String name;
	String company;
	String address;
	int[] phNumber;
	String socialAddress;
	public Family(String name, String company, String address, int[] phNumber, String socialAddress) {
		super();
		this.name = name;
		this.company = company;
		this.address = address;
		this.phNumber = phNumber;
		this.socialAddress = socialAddress;
	}
	public Family(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int[] getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(int[] phNumber) {
		this.phNumber = phNumber;
	}
	public String getSocialAddress() {
		return socialAddress;
	}
	public void setSocialAddress(String socialAddress) {
		this.socialAddress = socialAddress;
	}
	

}
