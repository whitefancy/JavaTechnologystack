package designpattern.observerpattern.javaweather;

public class Main {
    public static void main(String args[]){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay =new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay =new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.deleteObserver(forecastDisplay);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
