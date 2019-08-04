package designpattern.decoratorpattern.starbuzz;

public class Decaf extends Beverage {
    public Decaf(Size s) {
        size = s;
        discription = "Decaf" + "(" + size + ")";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}
