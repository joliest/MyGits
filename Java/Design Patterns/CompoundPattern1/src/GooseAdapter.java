
//adapter pattern
public class GooseAdapter implements Quackable {
	
	Goose goose;
	Observable observable;
	
	public GooseAdapter() {
		observable = new Observable(this);
	}
	
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	@Override
	public void quack() {
		goose.honk();
		//observable.notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		//observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		//observable.notifyObservers();
	}
	
	public String toString() {
		return "Goose";
	}

}
