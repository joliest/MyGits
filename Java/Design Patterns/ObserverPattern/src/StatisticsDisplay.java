
public class StatisticsDisplay implements Observer{
	
	private WeatherData weatherData;
	
	double temperature;
	double pressure;
	
	public StatisticsDisplay(WeatherData wd) {
		this.weatherData = wd;
		weatherData.registerObserver(this);
	}

	@Override
	public void update(double temp, double humid, double press) {
		this.temperature = temp;
		this.pressure = press;
		display();
	}

	@Override
	public void display() {
		System.out.println("Statistic Display");
		System.out.println("Temperature is: " + temperature + "C");
		System.out.println("Pressure is: " + pressure);
		
	}
	

}
