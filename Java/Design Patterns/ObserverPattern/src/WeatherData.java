import java.util.*;

public class WeatherData implements Subject{
	
	private ArrayList observers;
	
	private double temperature;
	private double humidity;
	private double pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void setMeasurements(double temp, double humid, double pressure) {
		temperature = temp;
		humidity = humid;
		pressure = pressure;
		measurementChanged();
	}
	
	public void measurementChanged() {
		notifyObservers();
	}
	
	public ArrayList getObservers() {
		return observers;
	}
	
}
