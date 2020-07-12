/*
COMMAND - consists a set of actions on a receiver.
		- provides one method - execute() that encapsulates the actions can be called to 
		  invoke the actions on the Receiver

 	This is one of the Command object.
 	It encapsulates the action to be performed when a light is turned on/off
 	The Remote object doesn't care what kind of specific action that this object executes
 	As long as its a command.
 */
public class LightOnCommand implements Command{
	
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}
	
	public String toString() {
		return light.toString();
	}

}
