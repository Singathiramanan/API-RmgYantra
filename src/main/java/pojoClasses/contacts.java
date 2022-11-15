package pojoClasses;

public class contacts {
	String firstName;
	String lastName;
	String companyName;
	int[] phoneNo;
	String address;
	String dob;
	String url;
	String relatedname;
	String socialAddress;
	Family[] objarr;

	public contacts(String firstName, String lastName, String companyName, int[] phoneNo, String address, String dob,
			String url, String relatedname, String socialAddress, Family[] objarr) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.dob = dob;
		this.url = url;
		this.relatedname = relatedname;
		this.socialAddress = socialAddress;
		this.objarr = objarr;
	}

	public contacts() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int[] phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRelatedname() {
		return relatedname;
	}

	public void setRelatedname(String relatedname) {
		this.relatedname = relatedname;
	}

	public String getSocialAddress() {
		return socialAddress;
	}

	public void setSocialAddress(String socialAddress) {
		this.socialAddress = socialAddress;
	}

	public Family[] getObjarr() {
		return objarr;
	}

	public void setObjarr(Family[] objarr) {
		this.objarr = objarr;
	}

}
