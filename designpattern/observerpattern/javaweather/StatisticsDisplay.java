package designpattern.observerpattern.javaweather;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature[];
    private float humidity[];
    private float pressure[];
    int times;
    private Observable observable;
    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
        //0:max 1:min 2:mean 3:current
        temperature = new float[4];
        humidity = new float[4];
        pressure = new float[4];
    }
    @Override
    public void display() {
        //显示最大，最小，平均观测值
        System.out.println("气象统计数据（基于 "+times+" 次统计数据）：");
        System.out.println("温度（华氏度）\t最大："+temperature[0]+" 最小："+temperature[1]+"平均："+temperature[2]);
        System.out.println("湿度（%）\t最大："+humidity[0]+" 最小："+humidity[1]+"平均："+humidity[2]);
        System.out.println("气压（千帕）\t最大："+pressure[0]+" 最小："+pressure[1]+"平均："+pressure[2]);
        System.out.println("显示完毕！");
    }

    @Override
    public void update(Observable obs,Object arg) {
        if(obs instanceof WeatherData)
        {
            WeatherData weatherData =(WeatherData)obs;
            float temp= weatherData.getTemperature();
            float humidity = weatherData.getHumidity();
            float pressure = weatherData.getPressure();
            temperature[3]=temp;
            this.humidity[3]=humidity;
            this.pressure[3]=pressure;
            if(times==0){
                temperature[0]=temp;
                temperature[1]=temp;
                temperature[2]=temp;
                this.humidity[0]=humidity;
                this.humidity[1]=humidity;
                this.humidity[2]=humidity;
                this.pressure[0]=pressure;
                this.pressure[1]=pressure;
                this.pressure[2]=pressure;
            }
            times++;
            if(temp>temperature[0])
                temperature[0]=temp;
            if(temp<temperature[1])
                temperature[1]=temp;
            temperature[2]=(temperature[2]*(times-1)+temp)/times;
            if(humidity>this.humidity[0])
                this.humidity[0]=humidity;
            if(humidity<this.humidity[1])
                this.humidity[1]=humidity;
            this.humidity[2]=(this.humidity[2]*(times-1)+humidity)/times;
            if(pressure>this.pressure[0])
                this.pressure[0]=humidity;
            if(pressure<this.pressure[1])
                this.pressure[1]=pressure;
            this.pressure[2]=(this.pressure[2]*(times-1)+pressure)/times;
            display();
        }
    }
}
