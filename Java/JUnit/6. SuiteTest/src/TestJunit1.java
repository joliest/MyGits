import static org.junit.Assert.assertEquals;

import org.junit.Test;

//create test cases classes
public class TestJunit1 {
	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test
	public void testPrintMessage() {
		System.out.println("Test printMessage()");
		assertEquals(message, messageUtil.printMessage());
	}
}
