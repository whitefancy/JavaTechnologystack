package designpattern.observerpattern.internetweather;

public interface Subject {
    //主题接口，给订阅者们提供订阅服务
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
