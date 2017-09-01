
public class ForecastDisplay implements Observer{
	
	private WeatherData weatherData;
	
	private double humidity;
	private double pressure;
	
	public ForecastDisplay(WeatherData wd) {
		this.weatherData = wd;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(double temp, double humid, double press) {
		this.humidity = humid;
		this.pressure = press;	
		display();
	}

	@Override
	public void display() {
		System.out.println("Forecast Display");
		System.out.println("Humidity is: " + humidity + "%");
		System.out.println("Pressure is: " + pressure);
	}



}
