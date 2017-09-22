
public class GarageDoor {
	
	private String garageDoorStatus = "closed";
	
	public void up() {
		garageDoorStatus = "open";
	}
	
	public void down() {
		garageDoorStatus = "closed";
	}
	
	public void stop() {
		garageDoorStatus = "half open";
	}
	
	public void lightOn() {
		garageDoorStatus = "awesome";
	}
	
	public void lightOff() {
		garageDoorStatus = "dark";
	}
	
	public String toString() {
		return "Garage door is " + garageDoorStatus;
	}

}
