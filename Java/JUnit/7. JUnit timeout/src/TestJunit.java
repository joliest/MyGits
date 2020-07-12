//If a test case takes more time than the specified number of milliseconds, then JUnit will automatically mark it as failed

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit {

		String message = "Robert";
		MessageUtil messageUtil = new MessageUtil(message);
		
		@Test(timeout = 1000) 
		public void testPrintMessage() {
			System.out.println("Inside printMessage()");
			messageUtil.printMessage();
		}
		
		@Test
		public void testSalutationMessage() {
			System.out.println("Inside salutationMessage()");
			message = "Hi!" + "Robert";
			assertEquals(message, messageUtil.salutationMessage());
		}
		
}
