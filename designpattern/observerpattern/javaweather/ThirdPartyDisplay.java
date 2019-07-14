package designpattern.observerpattern.javaweather;

import java.util.Observable;
import java.util.Observer;

public class ThirdPartyDisplay implements Observer, DisplayElement {
    @Override
    public void display() {
        //显示基于观测值的其他内容
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
