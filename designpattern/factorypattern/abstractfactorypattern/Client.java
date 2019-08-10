package designpattern.factorypattern.abstractfactorypattern;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        factory.CreateProductA();
        factory = new ConcreteFactory2();
        factory.CreateProductB();
    }
}
