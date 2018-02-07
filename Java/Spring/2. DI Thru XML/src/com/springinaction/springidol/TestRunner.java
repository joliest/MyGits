package com.springinaction.springidol;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] args) {
		//Result result = JUnitCore.runClasses(JugglerTester.class);
		Result result = JUnitCore.runClasses(PoeticJuggler.class);
		
		System.out.println("List of failures: ");
		for(Failure failure : result.getFailures()) {			
			System.out.println(failure);
		}
		
		System.out.println(result.wasSuccessful());
	}
}
