
public class RemoteControl {
	Command[] offCommand;	
	private Command[] onCommand;
	private Command[] offCommand;	
	private Command undoCommand;
	
	public RemoteControl() {
		onCommand = new Command[7];
		offCommand = new Command[7];
		
		undoCommand = new NoCommand();
		Command noCommand = new NoCommand();
		for(int i = 0; i < onCommand.length; i++) {
			onCommand[i] = noCommand;
			offCommand[i] = noCommand;
		}
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		this.onCommand[slot] = onCommand;
		this.offCommand[slot] = offCommand;
	}
	
	public void onWasPressed(int slot) {
		onCommand[slot].execute();
		undoCommand = onCommand[slot];
		System.out.println(onCommand[slot].toString());
	}
	
	public void offWasPressed(int slot) {
		offCommand[slot].execute();
		undoCommand = offCommand[slot];
		System.out.println(offCommand[slot].toString());
	}
	
	public void undo() {
		undoCommand.undo();
		System.out.println(undoCommand.toString());
	}
	
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("<--- Remote Control ---> \n");
		
		for(int i = 0; i < onCommand.length; i++) {
			stringBuff.append("slot[" + i  + "] " + onCommand[i].getClass().getName() + 
						"     " + offCommand[i].getClass().getName() + "\n "
					);
		}
		stringBuff.append("\n");
		return stringBuff.toString();
	}
}
