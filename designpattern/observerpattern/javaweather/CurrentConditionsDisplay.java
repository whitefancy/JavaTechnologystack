package designpattern.observerpattern.javaweather;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
    private float temperature;
    private float humidity;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable){
        this.observable =observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        //显示当前观测值
        System.out.println("当前天气：\n 温度："+temperature+" 华氏度\t湿度："+humidity+"%");
        System.out.println("显示完毕！");
    }

    @Override
    public void update(Observable obs,Object arg) {
        if(obs instanceof WeatherData)
        {
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
