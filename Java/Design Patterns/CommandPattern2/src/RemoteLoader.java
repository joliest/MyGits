
public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		
		Light light = new Light("Living Room");
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);
		
		Light lightInBedroom = new Light("Bed Room");
		Command lightOnBedroom = new LightOnCommand(lightInBedroom);
		Command lightOffBedroom = new LightOffCommand(lightInBedroom);
		
		GarageDoor door = new GarageDoor();
		Command garageDoorOpen = new GarageDoorUpCommand(door);
		Command garageDoorClose = new GarageDoorDownCommand(door);

		remote.setCommand(0, lightOn, lightOff);
		remote.setCommand(1, lightOnBedroom, lightOffBedroom);
		remote.setCommand(3, garageDoorOpen, garageDoorClose);
		
		System.out.print(remote);
		
		remote.offWasPressed(0);
		remote.onWasPressed(0);
		
		remote.offWasPressed(1);
		remote.onWasPressed(1);
		remote.undo();
		
		remote.offWasPressed(3);
	}
}
