package designpattern.decoratorpattern.starbuzz;

/**
 * 装饰者模式
 * 设计原则 开放-关闭原则 类应该对扩展开发，对修改关闭
 * 可以通过提供扩展的方法来保护代码免于修改
 * 遵循开放-关闭原则，通常要引入新的抽象层次，增加代码复杂度，最有可能修改的地方才需要
 * 饮料
 * 抽象类
 * 所有的饮料都必须继承自此类
 */
public abstract class Beverage {
    String discription = "Unknow Beverage";

    public String getDiscription() {
        return discription;
    }

    public abstract double cost();//cost必须在子类里实现

    @Override
    public String toString() {
        return discription + "$" + cost();
    }
}
