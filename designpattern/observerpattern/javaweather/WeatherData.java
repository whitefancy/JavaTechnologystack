package designpattern.observerpattern.javaweather;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    float getTemperature()
    {
        return temperature;
    }
    float getHumidity()
    {
        //湿度
        return humidity;
    }
    float getPressure()
    {
        //气压
        return pressure;
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public void measurementsChanged()
    {
        setChanged();
        notifyObservers();
    }
}
