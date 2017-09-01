
public class CurrentConditions implements Observer{
	
	private double temperature;
	private double humidity;

	private WeatherData weatherData;
	
	public CurrentConditions(WeatherData wd) {
		this.weatherData = wd;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(double temp, double humid, double press) {
		temperature = temp;
		humidity = humid;		
		display();
	}

	@Override
	public void display() {
		System.out.println("Current Conditions");
		System.out.println("Temperature: " + temperature + "C");
		System.out.println("Humidity: " + humidity + "%");		
	}



}
