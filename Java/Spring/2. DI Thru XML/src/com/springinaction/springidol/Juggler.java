package com.springinaction.springidol;

public class Juggler implements Performer{
	
	int beanBags;
	
	public Juggler() {}
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	@Override
	public void perform() {
		System.out.println("Juggling " + beanBags + " beanbags");
	}
	
	public int getBeanBags() {
		return beanBags;
	}

}
