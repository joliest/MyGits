
public class Light {
	 String status = "off";
	 String lightLocation = "";
	
	public Light(String location) {
		lightLocation = location;
	}
	
	public void On() {
		status = "on";
	}
	
	public void Off() {
		status = "off";
	}
	
	public String toString() {
		String lightStatus = lightLocation + "'s light is " + status;
		return lightStatus;
	}
}
