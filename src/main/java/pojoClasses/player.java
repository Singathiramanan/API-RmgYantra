package pojoClasses;

public class player {
	String name;
	String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public player(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public player(){
		
	}
}
