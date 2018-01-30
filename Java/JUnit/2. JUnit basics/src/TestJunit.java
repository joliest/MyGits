import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * this is a test class
 * add a method testPrintMessage() to test your class
 * add an Annotation @Test to method testPrintMessage()
 * implement the test condition and check the condition using assertEquals API of JUnit
 */
public class TestJunit {
	
	String message = "Hello world";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test
	public void testPrintMessage() {
		message = "New Word"; //uncomment this and you'll get failure
		assertEquals(message, messageUtil.printMessage());
	}
}
