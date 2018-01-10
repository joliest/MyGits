import java.util.ArrayList;
import java.util.Iterator;
//CompositePattern
public class Flock implements Quackable{
	
	ArrayList quackers = new ArrayList();
	Observable observable;
	
	public Flock() {
		observable = new Observable(this);
	}
	
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}

	@Override
	public void quack() {
		//Iterator pattern
		Iterator iterator = quackers.iterator();
		while(iterator.hasNext()) {
			Quackable quacker = (Quackable) iterator.next();
			quacker.quack();
			notifyObservers();
		}
		
		
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
		return "Flock";
	}


}
