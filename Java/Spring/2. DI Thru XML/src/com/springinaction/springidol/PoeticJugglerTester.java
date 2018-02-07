package com.springinaction.springidol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class PoeticJugglerTester {
	ApplicationContext ctx;
	PoeticJuggler performer; 
	
	public PoeticJugglerTester(){ }
	
	@Test
	public void checkPoemNotNull() {
		ctx = new ClassPathXmlApplicationContext("MySpringXMLConfig.xml");
		performer = (PoeticJuggler) ctx.getBean("ryan");
		assertEquals(performer.getBeanBags(), 13);
		assertNotNull(performer.getPoem());
	}
}
