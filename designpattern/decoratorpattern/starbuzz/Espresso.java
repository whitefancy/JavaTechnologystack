package designpattern.decoratorpattern.starbuzz;

/**
 * 浓缩咖啡
 */
public class Espresso extends Beverage {
    Espresso() {
        discription = "Espresso";//使用构造器来设置饮料的描述，该字段继承自description
    }

    @Override
    public double cost() {
        return 1.99;//现在不用管调料的钱，直接把当前咖啡的价格返回即可
    }
}
