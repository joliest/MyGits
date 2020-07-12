
public class GarageDoor {
	private String status = "closed";
	
	public void up() {
		status = "open";
	}
	
	public void down() {
		status = "closed";
	}
	
	public void stop() {
		status = "not complete";
	}
	
	public String toString() {
		String message = "Garage door is " + status;
		return message;
	}
}
