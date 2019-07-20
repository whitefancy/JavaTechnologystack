package designpattern.observerpattern.javaweather;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private Observable observable;
    public ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        //显示天气预报
        System.out.println("预计下一天的气温是 "+temperature+" 华氏度。");
        System.out.println("展示完毕！");
    }

    @Override
    public void update(Observable o, Object arg){
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            temperature = weatherData.getTemperature()+1;
            display();
        }
    }
}
