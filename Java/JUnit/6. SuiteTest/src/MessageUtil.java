//this class prints the given message on console
public class MessageUtil {
	private String message;
	
	//Constructor
	public MessageUtil(String message) {
		this.message = message;
	}
	
	//prints the message
	public String printMessage() {
		System.out.println(message);
		return message;
	}
	
	//say hi to the message
	public String salutationMessage() {
		message = "Hi! " + message;
		System.out.println(message);
		return message;
	}
}
