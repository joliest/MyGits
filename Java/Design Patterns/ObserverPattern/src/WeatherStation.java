
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditions condition = new CurrentConditions(weatherData);
		ForecastDisplay forecast = new ForecastDisplay(weatherData);
		StatisticsDisplay statistic = new StatisticsDisplay(weatherData);
		
		weatherData.setMeasurements(20, 30, 45);
	}
}
