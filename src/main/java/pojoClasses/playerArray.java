package pojoClasses;

public class playerArray {
	String team;
	player[] object;
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public player[] getObject() {
		return object;
	}
	public void setObject(player[] object) {
		this.object = object;
	}
	public playerArray(String team, player[] object) {
		super();
		this.team = team;
		this.object = object;
	}
	public playerArray(){
		
	}
}
