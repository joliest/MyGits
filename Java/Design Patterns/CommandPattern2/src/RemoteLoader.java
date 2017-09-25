
public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		
		Light light = new Light("Living Room");
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);

		remote.setCommand(0, lightOn, lightOff);
		
		System.out.print(remote);
		
		remote.offWasPressed(0);
		remote.onWasPressed(0);
	}
}
