package designpattern.strategypattern.SimUDuck;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    private void swim() {
        System.out.println("划水ing");
    }

    abstract void display();

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    void showTime() {
        flyBehavior.fly();
        quackBehavior.quack();
        swim();
        display();
        flyBehavior = new FlyNoWay();
        flyBehavior.fly();
        System.out.println("表演结束\n");
    }
}