package designpattern.decoratorpattern.starbuzz;

public class DarkRoast extends Beverage {
    DarkRoast(Size s) {
        size = s;
        discription = "Most Excellent Dark Roast" + "(" + size + ")";
    }

    @Override
    public double cost() {
        return .99 + Beverage.getExtra(size);
    }
}
