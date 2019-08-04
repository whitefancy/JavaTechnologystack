package designpattern.decoratorpattern.starbuzz;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        discription = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
