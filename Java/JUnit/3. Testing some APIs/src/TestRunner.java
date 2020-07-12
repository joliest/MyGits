import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.*;
import testjunits.*;

public class TestRunner {
	public static void main(String[] args) {
		
		/*
		 
		TODO: uncomment this if you need to test Assert, TestCase and TestResult
		 
		//change the parameter in runClasses when testing a certain class
		//Result result = JUnitCore.runClasses(TestJunit_Assert.class);
		//Result result = JUnitCore.runClasses(TestJunit_TestCase.class);
		Result result = JUnitCore.runClasses(TestJunit_TestResult.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
		
		*/
		
		//TODO: comment this if you not need to test TestSuite
		
		//add the test's in the suite
		TestSuite suite = new TestSuite(TestJunit_Assert.class, TestJunit_TestCase.class,
												TestJunit_TestResult.class);
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("Number of test cases = " + result.runCount());
	}
}
