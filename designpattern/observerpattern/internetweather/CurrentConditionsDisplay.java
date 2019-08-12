package designpattern.observerpattern.internetweather;

import designpattern.observerpattern.proto.Observer;
import designpattern.observerpattern.proto.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        //显示当前观测值
        System.out.println("当前天气：\n 温度：" + temperature + " 华氏度\t湿度：" + humidity + "%");
        System.out.println("显示完毕！");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temperature = temp;
        this.humidity = humidity;
        display();
    }
}
