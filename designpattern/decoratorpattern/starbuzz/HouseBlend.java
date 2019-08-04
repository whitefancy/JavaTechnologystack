package designpattern.decoratorpattern.starbuzz;

/**
 * 综合咖啡
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        discription = "HouseBlend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
