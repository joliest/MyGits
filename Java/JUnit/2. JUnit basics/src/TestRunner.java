import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
 This is a test runner class
 use static runClasses() method of JUnitCore class of JUnit to run the test case of the above created test class
 get the result of test cases run in Result object
 get failure(s) using the getFailures() method of Result object
 get Success result using the wasSuccessful() method of Result object
 */
public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
		
	}
}
