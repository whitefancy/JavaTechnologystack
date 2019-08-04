package designpattern.decoratorpattern.starbuzz;

/**
 * 在这里，使用继承 是为了达到“类型匹配”，而不是获得行为
 * 加入新的行为时，不是通过继承超类，而是由组合对象得来
 * 行为来自装饰者和基础组件，和其他装饰者之间的组合关系
 * 这里的Beverage，可以是抽象类，也可以是接口，如果重构前是什么，就避免改变它
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDiscription() {
        return beverage.getDiscription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.29 + beverage.cost();
    }
}
