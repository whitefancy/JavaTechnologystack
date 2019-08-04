package designpattern.decoratorpattern.starbuzz;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDiscription() {
        return beverage.getDiscription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.29 + beverage.cost();
    }
}
