package designpattern.decoratorpattern.starbuzz;

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDiscription() {
        return beverage.getDiscription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
