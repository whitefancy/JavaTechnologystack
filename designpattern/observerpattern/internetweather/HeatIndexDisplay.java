package designpattern.observerpattern.internetweather;

import designpattern.observerpattern.proto.Observer;
import designpattern.observerpattern.proto.Subject;

public class HeatIndexDisplay implements DisplayElement, Observer {
    private float heatIndex;
    private Subject weatherData;

    HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前炎热指数为： " + heatIndex);
        System.out.println("显示完毕！");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        heatIndex = (float) (16.9 + (0.18 * temp) + (0.00537 * humidity * pressure));
        display();
    }
}
