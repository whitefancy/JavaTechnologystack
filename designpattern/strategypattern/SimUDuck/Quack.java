package designpattern.strategypattern.SimUDuck;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱呱呱~呱！");
    }
}
