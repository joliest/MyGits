/*
Invoker - client calls setCommand() on an Invoker object
			and passes it the command object, where 
			it gets stored until its needed

 	When the button was pressed, this remote control wouldn't know the specific action it will perform
 	As long as you pass a command object, it will execute whichever command it does after the button is pressed.
 	
 */
public class SimpleRemoteControl {
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void buttonWasPressed() {
		command.execute();
		System.out.println(command);
	}
}
