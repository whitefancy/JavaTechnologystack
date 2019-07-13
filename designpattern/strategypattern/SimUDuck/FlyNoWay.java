package designpattern.strategypattern.SimUDuck;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //不会飞
        System.out.println("我不飞");
    }
}
