
public class GarageDoorDownCommand implements Command{
	
	private GarageDoor door;
	
	public GarageDoorDownCommand(GarageDoor door) {
		this.door = door;
	}

	@Override
	public void execute() {
		door.down();
	}

	@Override
	public void undo() {
		door.up();
	}
	
	public String toString() {
		return door.toString();
	}
	
}
