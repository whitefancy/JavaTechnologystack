package designpattern.strategypattern.SimUDuck;

public class FlyWithWings implements FlyBehavior {
    public void fly(){
        System.out.println("我在飞，我好快乐啊");
    }
}
