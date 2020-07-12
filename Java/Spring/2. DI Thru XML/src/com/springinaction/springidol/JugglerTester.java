package com.springinaction.springidol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JugglerTester {
	ApplicationContext ctx;
	Juggler performer; 
	
	@Test
	public void checkNumOfBeanBags() {
		ctx = new ClassPathXmlApplicationContext("MySpringXMLConfig.xml");
		performer = (Juggler) ctx.getBean("duke");
		assertEquals(performer.getBeanBags(), 13);
	}
}
