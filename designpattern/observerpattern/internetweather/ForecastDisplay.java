package designpattern.observerpattern.internetweather;

import designpattern.observerpattern.proto.Observer;
import designpattern.observerpattern.proto.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private Subject weatherData;

    ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        //显示天气预报
        System.out.println("预计下一天的气温是 " + temperature + " 华氏度。");
        System.out.println("展示完毕！");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temperature = temp + 1;
        display();
    }
}
