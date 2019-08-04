package designpattern.decoratorpattern.starbuzz;

public class Decaf extends Beverage {
    public Decaf() {
        discription = "Decaf";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}
