
public class RedheadDuck implements Quackable {
	
	Observable observable;
	
	public RedheadDuck() {
		observable = new Observable(this);
	}
	
	@Override
	public void quack() {
		System.out.println("Quack, Quack, Quack!");
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}
	
	public String toString() {
		return "Redhead Duck";
	}

	
}
