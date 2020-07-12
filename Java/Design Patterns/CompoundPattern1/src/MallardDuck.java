
public class MallardDuck implements Quackable {
	Observable observable;
	
	public MallardDuck() {
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		System.out.println("Quaaack, Quaack!");
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
		return "Mallard Duck";
	}

	

}
