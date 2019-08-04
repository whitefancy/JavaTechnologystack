package designpattern.decoratorpattern.starbuzz;

/**
 * 综合咖啡
 */
public class HouseBlend extends Beverage {
    HouseBlend(Size s) {
        size = s;
        discription = "HouseBlend" + "(" + size + ")";
    }

    @Override
    public double cost() {
        return .89;
    }
}
