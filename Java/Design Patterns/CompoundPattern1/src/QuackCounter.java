
//decorator pattern
public class QuackCounter implements Quackable{
	
	Quackable duck;
	static int numberOfQuacks;
	
	Observable observable;
	
	public QuackCounter() {
		observable = new Observable(this);
	}
	
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		duck.quack();
		//observable.notifyObservers();
		numberOfQuacks++;
	}
	
	public static int getQuacks() {
		return numberOfQuacks++;
	}
	
	@Override
	public void registerObserver(Observer observer) {
		//observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		//observable.notifyObservers();
	}


}
