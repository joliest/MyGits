/* 
 
CLIENT - responsible for creating the command object.
 
 	This Simple remote's only job is when a button is pressed, it will performs an action.
 	It doesn't care what that action would be.
 	
 	That action was encapsulated as command object. Command Object has one method, execute() 
 	it contains the action that it needs to perform after the button is pressed.
 */
public class SimpleRemoteTest {
	public static void main(String[] args) {
		
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		//lights on command
		Light light = new Light();
		Command turnOnLight = new LightOnCommand(light);
		
		//Garage Door open command
		GarageDoor garageDoor = new GarageDoor();
		Command garageOpen = new GarageDoorOpenCommand(garageDoor);

		remote.setCommand(turnOnLight);
		remote.buttonWasPressed();
		
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
		
		
		
	}
}
