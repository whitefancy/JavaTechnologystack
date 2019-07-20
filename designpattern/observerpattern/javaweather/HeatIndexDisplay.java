package designpattern.observerpattern.javaweather;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements DisplayElement, Observer {
    private float heatIndex;
    private Observable observable;
    public HeatIndexDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("当前炎热指数为： "+heatIndex);
        System.out.println("显示完毕！");
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            heatIndex = (float) (16.9 + (0.18 * weatherData.getTemperature()) + (0.00537 * weatherData.getHumidity() * weatherData.getPressure()));
            display();
        }
    }
}
