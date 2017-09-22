
public class Light {
	
	private String lightStatus = "off";
	
	public void turnOn() {
		lightStatus = "on";
	}
	
	public void turnOff() {
		lightStatus = "off";
	}
	
	public String toString() {
		return "Light is " + lightStatus;
	}

}
