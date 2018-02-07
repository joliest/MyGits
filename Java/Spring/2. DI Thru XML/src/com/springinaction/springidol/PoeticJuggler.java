package com.springinaction.springidol;

public class PoeticJuggler extends Juggler{
	
	private Poem poem;



	@Override
	public void perform() {
		super.perform();
		System.out.println("While reciting . . ");
		poem.recite();
	}



	public PoeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}
	
	public Poem getPoem() {
		return poem;
	}
	
	
}
