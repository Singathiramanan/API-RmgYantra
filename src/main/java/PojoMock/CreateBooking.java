package PojoMock;

public class CreateBooking {
	String firstname;
	String lastname;
	int totalprice;
	boolean depositpaid;
	Object BookingDates;
	String additionalneeds;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public Object getBookingDates() {
		return BookingDates;
	}
	public void setBookingDates(Object bookingDates) {
		BookingDates = bookingDates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public CreateBooking(String firstname, String lastname, int totalprice, boolean depositpaid, Object bookingDates,
			String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		BookingDates = bookingDates;
		this.additionalneeds = additionalneeds;
	}
	public CreateBooking(){
		
	}
}
